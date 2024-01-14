package com.gadgets.repair.system.services.customer;

import com.gadgets.repair.system.models.dtos.CustomerDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.requests.CustomerRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface CustomerValidationService {
    void validateUniqueCustomer(CustomerRequestDTO customerRequestDTO);

    Customer getValidCustomer(Long customerId);
}