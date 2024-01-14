package com.gadgets.repair.system.models.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TechnicianRequestDTO {

    @NotBlank(message = "Invalid first name")
    private String technicianFirstName;
    @NotBlank(message = "Invalid last name")
    private String technicianLastName;
    @NotBlank(message = "Invalid email")
    @Email(message = "Invalid email")
    private String technicianEmail;
}
