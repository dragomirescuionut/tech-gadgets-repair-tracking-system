package com.gadgets.repair.system.models.dtos;

import com.gadgets.repair.system.models.entities.Ticket;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class TechnicianDTO {

    private Long id;
    @NotBlank(message = "Invalid first name")
    private String technicianFirstName;
    @NotBlank(message = "Invalid last name")
    private String technicianLastName;
    @NotBlank(message = "Invalid email")
    @Email(message = "Invalid email")
    private String technicianEmail;
    private List<Ticket> ticketList = new ArrayList<>();
}
