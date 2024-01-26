package com.gadgets.repair.system.services.ticket;

import com.gadgets.repair.system.exceptions.ResourceNotFoundException;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Technician;
import com.gadgets.repair.system.repositories.customer.CustomerRepository;
import com.gadgets.repair.system.repositories.technician.TechnicianRepository;
import com.gadgets.repair.system.repositories.ticket.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketValidationServiceImpl implements TicketValidationService {
    private final CustomerRepository customerRepository;
    private final TechnicianRepository technicianRepository;

    public TicketValidationServiceImpl(TicketRepository ticketRepository, CustomerRepository customerRepository, TechnicianRepository technicianRepository) {
        this.customerRepository = customerRepository;
        this.technicianRepository = technicianRepository;
    }

    @Override
    public Customer getValidCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with the provided id not found!"));
    }

    @Override
    public Technician getValidTechnician(Long technicianId) {
        return technicianRepository.findById(technicianId)
                .orElseThrow(() -> new ResourceNotFoundException("Technician with the provided id not found!"));
    }
}
