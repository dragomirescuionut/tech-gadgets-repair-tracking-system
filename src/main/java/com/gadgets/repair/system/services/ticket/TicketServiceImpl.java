package com.gadgets.repair.system.services.ticket;

import com.gadgets.repair.system.exceptions.ResourceNotFoundException;
import com.gadgets.repair.system.models.dtos.CustomerDTO;
import com.gadgets.repair.system.models.dtos.InventoryDTO;
import com.gadgets.repair.system.models.dtos.TechnicianDTO;
import com.gadgets.repair.system.models.dtos.requests.InventoryRequestDTO;
import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.InventoryResponseDTO;
import com.gadgets.repair.system.models.dtos.responses.TicketResponseDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Inventory;
import com.gadgets.repair.system.models.entities.Technician;
import com.gadgets.repair.system.models.entities.Ticket;
import com.gadgets.repair.system.repositories.inventory.InventoryRepository;
import com.gadgets.repair.system.repositories.ticket.TicketRepository;
import com.gadgets.repair.system.utils.DeviceType;
import com.gadgets.repair.system.utils.Status;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {
    private final ModelMapper modelMapper;
    private final TicketValidationService ticketValidationService;

    private final TicketRepository ticketRepository;
    private final InventoryRepository inventoryRepository;

    public TicketServiceImpl(ModelMapper modelMapper, TicketValidationService ticketValidationService, TicketRepository ticketRepository, InventoryRepository inventoryRepository) {
        this.modelMapper = modelMapper;
        this.ticketValidationService = ticketValidationService;
        this.ticketRepository = ticketRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    @Override
    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Ticket ticket = modelMapper.map(ticketRequestDTO, Ticket.class);
        Customer customer = ticketValidationService.getValidCustomer(ticketRequestDTO.getCustomerId());
        Technician technician = ticketValidationService.getValidTechnician(ticketRequestDTO.getTechnicianId());
        //Status.validateStatusCode(ticketRequestDTO.getStatus().toString());
        ticket.setCreatedAt(LocalDate.now());
        ticket.setCustomer(customer);
        ticket.setTechnician(technician);

        Ticket savedTicket = ticketRepository.save(ticket);
        log.info("Ticket with id {} saved in data base", savedTicket.getId());


        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        TechnicianDTO technicianDTO = modelMapper.map(technician, TechnicianDTO.class);
        TicketResponseDTO ticketResponseDTO = modelMapper.map(savedTicket, TicketResponseDTO.class);
        ticketResponseDTO.setCustomer(customerDTO);
        ticketResponseDTO.setTechnician(technicianDTO);

        return ticketResponseDTO;
    }

    @Override
    public List<TicketResponseDTO> getFilteredTickets(Status status, DeviceType deviceType) {
        List<Ticket> tickets = ticketRepository.findFilteredTickets(status, deviceType);
        log.info("Number of tickets " + tickets.size());
        return tickets.stream()
                .map(ticket -> modelMapper.map(ticket, TicketResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public TicketResponseDTO updateTicket(Long ticketId, TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket with id " + ticketId + " not found"));

        if (ticketRequestDTO.getIssueDescription() != null) {
            ticket.setIssueDescription(ticketRequestDTO.getIssueDescription());
        }
        if (ticketRequestDTO.getStatus() != null) {
            ticket.setStatus(ticketRequestDTO.getStatus());
            if (ticketRequestDTO.getStatus() == Status.COMPLETED) {
                ticket.setCompletionDate(LocalDate.now());
            }
        }
        if (ticketRequestDTO.getEstimatedCompletionDate() != null) {
            ticket.setEstimatedCompletionDate(ticketRequestDTO.getEstimatedCompletionDate());
        }
        if (ticketRequestDTO.getInventoryList() != null && !ticketRequestDTO.getInventoryList().isEmpty()) {
            List<Long> inventoryIds = ticketRequestDTO.getInventoryList().stream()
                    .map(InventoryDTO::getId).toList();
            log.info("Inventory ids:" + inventoryIds);
            List<Inventory> inventories = inventoryRepository.findByIdIn(inventoryIds);
            log.info("Fetched Inventories: " + inventories);
            ticket.setInventoryList(inventories);

        }
        Ticket savedTicket = ticketRepository.save(ticket);
        log.info("Ticket with id {} has been successfully updated", savedTicket.getId());
        return modelMapper.map(savedTicket, TicketResponseDTO.class);
    }
}