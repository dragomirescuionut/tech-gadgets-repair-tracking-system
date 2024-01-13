package com.gadgets.repair.system.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gadgets.repair.system.exceptions.customer.CustomerNotFoundException;
import com.gadgets.repair.system.exceptions.customer.DuplicateCustomerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private final ObjectMapper objectMapper;

    public GlobalExceptionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(DuplicateCustomerException.class)
    public ResponseEntity<String> duplicateCustomerException(DuplicateCustomerException duplicateCustomerException) {
        return new ResponseEntity<>(objectToString(Map.of("message", duplicateCustomerException.getMessage())), BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> customerNotFoundException(CustomerNotFoundException customerNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", customerNotFoundException.getMessage())), BAD_REQUEST);
    }

    private String objectToString(Object response) {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            log.error("Error processing response to string.");
            return "Internal error";
        }
    }
}