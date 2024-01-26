package com.gadgets.repair.system.services.ticket;

import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.TicketResponseDTO;
import com.gadgets.repair.system.models.entities.Ticket;
import com.gadgets.repair.system.utils.DeviceType;
import com.gadgets.repair.system.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface TicketService {
    TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO);

    List<TicketResponseDTO> getFilteredTickets(Status status, DeviceType deviceType);

    TicketResponseDTO updateTicket(Long ticketId, TicketRequestDTO ticketRequestDTO);
}
