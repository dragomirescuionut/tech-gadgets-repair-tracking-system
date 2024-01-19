package com.gadgets.repair.system.models.dtos;

import lombok.Data;
@Data
public class TechnicianDTO {
    private Long id;
    private String technicianFirstName;
    private String technicianLastName;
    private String technicianEmail;
}
