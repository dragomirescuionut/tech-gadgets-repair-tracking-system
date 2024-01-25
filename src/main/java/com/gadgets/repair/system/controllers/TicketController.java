package com.gadgets.repair.system.controllers;

import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.TicketResponseDTO;
import com.gadgets.repair.system.services.ticket.TicketServiceImpl;
import com.gadgets.repair.system.utils.DeviceType;
import com.gadgets.repair.system.utils.Status;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tickets")
@Validated
public class TicketController {
    private final TicketServiceImpl ticketService;

    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketResponseDTO> createTicket(@Valid @RequestBody TicketRequestDTO ticketRequestDTO) {
        return ResponseEntity.ok(ticketService.createTicket(ticketRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> getFilteredTickets(@RequestParam("status") Status status,
                                                                      @RequestParam("deviceType") DeviceType deviceType) {
        return ResponseEntity.ok(ticketService.getFilteredTickets(status, deviceType));
    }
}
