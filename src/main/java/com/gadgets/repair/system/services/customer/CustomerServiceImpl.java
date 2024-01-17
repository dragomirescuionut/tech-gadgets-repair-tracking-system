package com.gadgets.repair.system.services.customer;

import com.gadgets.repair.system.models.dtos.responses.CustomerResponseDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.dtos.requests.CustomerRequestDTO;
import com.gadgets.repair.system.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final CustomerValidationService customerValidationService;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, CustomerValidationService customerValidationService) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.customerValidationService = customerValidationService;
    }

    @Transactional
    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        customerValidationService.validateUniqueCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(modelMapper.map(customerRequestDTO, Customer.class));
        log.info("Customer with id {} saved in data base", savedCustomer.getId());

        return modelMapper.map(savedCustomer, CustomerResponseDTO.class);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerResponseDTO.class))
                .toList();
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long customerId, CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerValidationService.getValidCustomer(customerId);
        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setLastName(customerRequestDTO.getLastName());
        customer.setEmail(customerRequestDTO.getEmail());

        Customer savedCustomer = customerRepository.save(customer);
        log.info("Customer {} : {} updated in data base. ", savedCustomer.getId(), savedCustomer.getFirstName());
        return modelMapper.map(savedCustomer, CustomerResponseDTO.class);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerValidationService.getValidCustomer(customerId);

        customerRepository.deleteById(customerId);
        log.info("Customer with id {} deleted.", customerId);

    }
}
