package com.gadgets.repair.system.services.ticket;

import com.gadgets.repair.system.models.dtos.CustomerDTO;
import com.gadgets.repair.system.models.dtos.TechnicianDTO;
import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.TicketResponseDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Technician;
import com.gadgets.repair.system.models.entities.Ticket;
import com.gadgets.repair.system.repositories.CustomerRepository;
import com.gadgets.repair.system.repositories.TicketRepository;
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
public class TicketServiceImpl implements TicketService{
    private final ModelMapper modelMapper;
    private final TicketValidationService ticketValidationService;

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(ModelMapper modelMapper, TicketValidationService ticketValidationService, TicketRepository ticketRepository) {
        this.modelMapper = modelMapper;
        this.ticketValidationService = ticketValidationService;
        this.ticketRepository = ticketRepository;
    }
    @Transactional
    @Override
    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Ticket ticket = modelMapper.map(ticketRequestDTO,Ticket.class);
        Customer customer = ticketValidationService.getValidCustomer(ticketRequestDTO.getCustomerId());
        Technician technician = ticketValidationService.getValidTechnician(ticketRequestDTO.getTechnicianId());
        //Status.validateStatusCode(ticketRequestDTO.getStatus().toString());
        ticket.setCreatedAt(LocalDate.now());
        ticket.setCustomer(customer);
        ticket.setTechnician(technician);

        Ticket savedTicket = ticketRepository.save(ticket);
        log.info("Ticket with id {} saved in data base", savedTicket.getId());

        CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
        TechnicianDTO technicianDTO = modelMapper.map(technician, TechnicianDTO.class);
        TicketResponseDTO ticketResponseDTO = modelMapper.map(savedTicket,TicketResponseDTO.class);
        ticketResponseDTO.setCustomer(customerDTO);
        ticketResponseDTO.setTechnician(technicianDTO);

        return ticketResponseDTO;
    }
    @Override
    public List<TicketResponseDTO> getFilteredTickets(Status status, DeviceType deviceType) {
        List<Ticket> tickets = ticketRepository.findFilteredTickets(status,deviceType);
        log.info("Number of tickets " + tickets.size());
        return tickets.stream()
                .map(ticket -> modelMapper.map(ticket, TicketResponseDTO.class))
                .collect(Collectors.toList());
    }
}