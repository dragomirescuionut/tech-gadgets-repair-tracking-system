package com.gadgets.repair.system.services.ticket;

import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.TicketResponseDTO;
import com.gadgets.repair.system.models.entities.Ticket;
import com.gadgets.repair.system.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService{
    private final ModelMapper modelMapper;
    private final ModelMapper ticketModelMapper;
    private final TicketValidationService ticketValidationService;

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(ModelMapper modelMapper, ModelMapper ticketModelMapper, TicketValidationService ticketValidationService, TicketRepository ticketRepository) {
        this.modelMapper = modelMapper;
        this.ticketModelMapper = ticketModelMapper;
        this.ticketValidationService = ticketValidationService;
        this.ticketRepository = ticketRepository;
    }
    @Transactional
    @Override
    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) {

        ticketRequestDTO.setCreatedAt(LocalDate.now());
        Ticket ticket = modelMapper.map(ticketRequestDTO,Ticket.class);
        Ticket savedTicket = ticketRepository.save(ticket);
        log.info("Ticket with id {} saved in data base", savedTicket.getId());

        return modelMapper.map(savedTicket, TicketResponseDTO.class);
    }
}
