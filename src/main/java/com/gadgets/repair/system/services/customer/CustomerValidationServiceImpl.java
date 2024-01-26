package com.gadgets.repair.system.services.customer;

import com.gadgets.repair.system.exceptions.ResourceNotFoundException;
import com.gadgets.repair.system.exceptions.DuplicateResourceException;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.dtos.requests.CustomerRequestDTO;
import com.gadgets.repair.system.repositories.customer.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerValidationServiceImpl implements CustomerValidationService {
    private final CustomerRepository customerRepository;

    public CustomerValidationServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void validateUniqueCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer foundCustomer = customerRepository.findByEmail(customerRequestDTO.getEmail());
        if (foundCustomer != null) {
            throw new DuplicateResourceException("Email already exists!");
        }
    }

    @Override
    public Customer getValidCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + "not found"));
        return customer;
    }
}