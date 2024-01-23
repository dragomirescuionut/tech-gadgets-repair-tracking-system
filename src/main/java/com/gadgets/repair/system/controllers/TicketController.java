package com.gadgets.repair.system.controllers;

import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.TicketResponseDTO;
import com.gadgets.repair.system.services.ticket.TicketServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/tickets")
@Validated
public class TicketController {
    private final TicketServiceImpl ticketService;

    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketResponseDTO> createTicket(@Valid @RequestBody TicketRequestDTO ticketRequestDTO){
        return ResponseEntity.ok(ticketService.createTicket(ticketRequestDTO));
    }
}
