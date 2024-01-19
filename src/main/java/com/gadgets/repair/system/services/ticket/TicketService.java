package com.gadgets.repair.system.services.ticket;

import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.TicketResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface TicketService {
    TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO);
}
