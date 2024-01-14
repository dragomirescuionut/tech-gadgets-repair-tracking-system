package com.gadgets.repair.system.services.customer;

import com.gadgets.repair.system.models.dtos.CustomerDTO;
import com.gadgets.repair.system.models.requests.CustomerRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerDTO createCustomer(CustomerRequestDTO customerRequestDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO updateCustomer(Long customerId, CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(Long customerId);
}
