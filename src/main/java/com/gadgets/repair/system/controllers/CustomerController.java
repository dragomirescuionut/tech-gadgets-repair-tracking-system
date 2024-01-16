package com.gadgets.repair.system.controllers;

import com.gadgets.repair.system.models.dtos.CustomerDTO;
import com.gadgets.repair.system.models.dtos.requests.CustomerRequestDTO;
import com.gadgets.repair.system.services.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long customerId, @Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customerRequestDTO));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().build();
    }
}