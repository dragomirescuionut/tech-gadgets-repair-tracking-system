package com.gadgets.repair.system.services.ticket;

import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Technician;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TicketValidationService {
    Optional<Customer> getValidCustomer(TicketRequestDTO ticketRequestDTO);
    Optional<Technician> getValidTechnician(TicketRequestDTO ticketRequestDTO);
}
