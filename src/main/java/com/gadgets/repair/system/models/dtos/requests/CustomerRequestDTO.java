package com.gadgets.repair.system.models.dtos.requests;

import com.gadgets.repair.system.models.entities.Ticket;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CustomerRequestDTO {

    @NotBlank(message = "Invalid first name")
    private String firstName;
    @NotBlank(message = "Invalid last name")
    private String lastName;
    @Size(min = 5, max = 25, message
            = "User name must be between 10 and 25 characters")
    @NotBlank(message = "Invalid user name")
    private String userName;
    @NotBlank(message = "Invalid email")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Invalid address")
    private String address;
    @Past(message = "Invalid date of birth!")
    private LocalDate dateOfBirth;
}