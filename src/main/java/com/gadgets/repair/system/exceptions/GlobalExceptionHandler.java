package com.gadgets.repair.system.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Map<String, String>> duplicateCustomerException(DuplicateResourceException duplicateCustomerException) {
        return new ResponseEntity<>(Map.of("message", duplicateCustomerException.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> customerNotFoundException(ResourceNotFoundException customerNotFoundException) {
        return new ResponseEntity<>(Map.of("message", customerNotFoundException.getMessage()), NOT_FOUND);
    }

    @ExceptionHandler(InvalidEnumValueException.class)
    public ResponseEntity<Map<String, String>> invalidEnumValueException(InvalidEnumValueException invalidEnumValueException) {
        log.error("InvalidEnumValueException caught: {}", invalidEnumValueException.getMessage());
        return new ResponseEntity<>(Map.of("message", invalidEnumValueException.getMessage()), BAD_REQUEST);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}