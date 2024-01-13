package com.gadgets.repair.system.models.requests;

import com.gadgets.repair.system.models.entities.Ticket;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class TechnicianRequestDTO {

    @NotBlank(message = "Invalid first name")
    private String technicianFirstName;
    @NotBlank(message = "Invalid last name")
    private String technicianLastName;
    @NotBlank(message = "Invalid email")
    @Email(message = "Invalid email")
    private String technicianEmail;
}
