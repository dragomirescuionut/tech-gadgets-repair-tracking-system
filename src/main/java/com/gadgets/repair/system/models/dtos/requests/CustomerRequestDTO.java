package com.gadgets.repair.system.models.dtos.requests;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;


@Data
public class CustomerRequestDTO {

    @NotBlank(message = "First name is required!")
    @Pattern(regexp = "[\\p{L} ]+", message = "Invalid characters!")
    @Size(min =3 , max = 50, message = "First name must be between 3 and 50 characters!")
    private String firstName;
    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "[\\p{L} ]+", message = "Invalid characters!")
    @Size(min =3 , max = 50, message = "Last name must be between 3 and 50 characters!")
    private String lastName;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email!")
    private String email;
    @NotBlank(message = "Phone number is required!")
    @Size(min = 10, max = 15, message = "Phone number length must be between 10 and 15 characters!")
    private String phoneNumber;
    @NotBlank(message = "Address is required!")
    private String address;
    @Past(message = "Invalid date of birth!")
    private LocalDate dateOfBirth;
}