package com.gadgets.repair.system.models.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TechnicianRequestDTO {

    @NotBlank(message = "First name is required!")
    @Pattern(regexp = "[\\p{L} ]+", message = "Invalid characters!")
    @Size(min =3 , max = 50, message = "First name must be between 3 and 50 characters!")
    private String technicianFirstName;
    @NotBlank(message = "Last name is required!")
    @Pattern(regexp = "[\\p{L} ]+", message = "Invalid characters!")
    @Size(min =3 , max = 50, message = "Last name must be between 3 and 50 characters!")
    private String technicianLastName;
    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email")
    private String technicianEmail;

}
