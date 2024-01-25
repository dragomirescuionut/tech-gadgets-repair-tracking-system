package com.gadgets.repair.system.unit_tests;

import com.gadgets.repair.system.exceptions.DuplicateResourceException;
import com.gadgets.repair.system.models.dtos.requests.CustomerRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.CustomerResponseDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.repositories.CustomerRepository;
import com.gadgets.repair.system.services.customer.CustomerServiceImpl;
import com.gadgets.repair.system.services.customer.CustomerValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerValidationService customerValidationService;
    @Spy
    private ModelMapper modelMapper;
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void createCustomerTestShouldPass() {
        //GIVEN
        LocalDate dob = LocalDate.of(199,1,1);
        CustomerRequestDTO customerRequestDTO = CustomerRequestDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@gmail.com")
                .phoneNumber("12345678900")
                .address("1234 Java Street")
                .dateOfBirth(dob)
                .build();
        CustomerResponseDTO customerResponseDTO = CustomerResponseDTO.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@gmail.com")
                .phoneNumber("12345678900")
                .address("1234 Java Street")
                .dateOfBirth(dob)
                .build();
        Customer customer = Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@gmail.com")
                .phoneNumber("12345678900")
                .address("1234 Java Street")
                .dateOfBirth(dob)
                .build();
        Customer savedCustomer = Customer.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@gmail.com")
                .phoneNumber("12345678900")
                .address("1234 Java Street")
                .dateOfBirth(dob)
                .customerTickets(Collections.emptyList())
                .build();
        //WHEN
        when(customerRepository.save(customer)).thenReturn(savedCustomer);
        when(modelMapper.map(customerRequestDTO, Customer.class)).thenReturn(customer);
        when(modelMapper.map(savedCustomer, CustomerResponseDTO.class)).thenReturn(customerResponseDTO);

        CustomerResponseDTO actualResponse = customerService.createCustomer(customerRequestDTO);

        //THEN
        verify(customerValidationService).validateUniqueCustomer(customerRequestDTO);
        verify(customerRepository).save(customer);
        assertNotNull(actualResponse.getId());
        assertEquals(customerRequestDTO.getEmail(), actualResponse.getEmail());
    }
    @Test
    void createCustomer_ShouldFail_WhenCustomerAlreadyExists(){
        //GIVEN
        CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
        customerRequestDTO.setFirstName("John");
        customerRequestDTO.setLastName("Doe");
        customerRequestDTO.setEmail("john.doe@gmail.com");

        doThrow(new DuplicateResourceException("Customer already exists"))
                .when(customerValidationService).validateUniqueCustomer(any(CustomerRequestDTO.class));

        //WHEN & THEN
        assertThrows(DuplicateResourceException.class, ()->{
            customerService.createCustomer(customerRequestDTO);
        });

        verify(customerValidationService).validateUniqueCustomer(customerRequestDTO);
        verify(customerRepository, never()).save(any(Customer.class));

    }
}
