package com.gadgets.repair.system.services.ticket;

import com.gadgets.repair.system.exceptions.ResourceNotFoundException;
import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Technician;
import com.gadgets.repair.system.repositories.CustomerRepository;
import com.gadgets.repair.system.repositories.TechnicianRepository;
import com.gadgets.repair.system.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketValidationServiceImpl implements TicketValidationService {
    private final CustomerRepository customerRepository;
    private final TechnicianRepository technicianRepository;

    public TicketValidationServiceImpl(TicketRepository ticketRepository, CustomerRepository customerRepository, TechnicianRepository technicianRepository) {
        this.customerRepository = customerRepository;
        this.technicianRepository = technicianRepository;
    }

    @Override
    public Optional<Customer> getValidCustomer(TicketRequestDTO ticketRequestDTO) {
        Optional<Customer> foundCustomer = customerRepository.findById(ticketRequestDTO.getCustomerId());
        if (foundCustomer == null) {
            throw new ResourceNotFoundException("Customer or technician does not exist!");
        }

        return foundCustomer;
    }

    @Override
    public Optional<Technician> getValidTechnician(TicketRequestDTO ticketRequestDTO) {
        Optional<Technician> foundTechnician = technicianRepository.findById(ticketRequestDTO.getTechnicianId());
        if (foundTechnician == null) {
            throw new ResourceNotFoundException("Technician does not exist!");
        }
        return foundTechnician;
    }
}
