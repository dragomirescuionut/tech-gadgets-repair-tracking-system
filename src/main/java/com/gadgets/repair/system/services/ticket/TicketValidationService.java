package com.gadgets.repair.system.services.ticket;

import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Technician;
import org.springframework.stereotype.Service;

@Service
public interface TicketValidationService {
    Customer getValidCustomer(Long customerId);
    Technician getValidTechnician(Long technicianId);
}