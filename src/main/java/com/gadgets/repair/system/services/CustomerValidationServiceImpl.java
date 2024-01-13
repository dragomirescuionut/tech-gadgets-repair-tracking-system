package com.gadgets.repair.system.services;

import com.gadgets.repair.system.exceptions.customer.CustomerNotFoundException;
import com.gadgets.repair.system.exceptions.customer.DuplicateCustomerException;
import com.gadgets.repair.system.models.dtos.CustomerDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.requests.CustomerRequestDTO;
import com.gadgets.repair.system.repositories.CustomerRepository;
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
            throw new DuplicateCustomerException("Email already exists!");
        }
    }

    @Override
    public Customer getValidCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + customerId + "not found"));

        return customer;
    }
}