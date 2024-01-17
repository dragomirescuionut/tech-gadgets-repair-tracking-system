package com.gadgets.repair.system.models.dtos.responses;

import com.gadgets.repair.system.models.entities.Ticket;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class TechnicianResponseDTO {

    private Long id;
    private String technicianFirstName;
    private String technicianLastName;
    private String technicianEmail;
    private List<Ticket> ticketList = new ArrayList<>();
}
