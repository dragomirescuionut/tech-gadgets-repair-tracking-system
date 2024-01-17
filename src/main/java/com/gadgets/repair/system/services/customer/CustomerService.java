package com.gadgets.repair.system.services.customer;

import com.gadgets.repair.system.models.dtos.responses.CustomerResponseDTO;
import com.gadgets.repair.system.models.dtos.requests.CustomerRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO updateCustomer(Long customerId, CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(Long customerId);
}
