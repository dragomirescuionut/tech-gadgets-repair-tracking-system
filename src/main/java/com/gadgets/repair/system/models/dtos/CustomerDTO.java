package com.gadgets.repair.system.models.dtos;


import com.gadgets.repair.system.models.entities.Ticket;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    @NotBlank(message = "Invalid first name")
    private String firstName;
    @NotBlank(message = "Invalid last name")
    private String lastName;
    @NotBlank(message = "Invalid user name")
    private String userName;
    @NotBlank(message = "Invalid email")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Invalid address")
    private String address;
    @NotBlank(message = "Invalid date of birth!")
    @Past(message = "Invalid date of birth!")
    private LocalDate dateOfBirth;
    private List<Ticket> customerTickets;
}