package com.gadgets.repair.system.models.dtos.responses;

import com.gadgets.repair.system.models.DeviceType;
import com.gadgets.repair.system.models.Status;
import com.gadgets.repair.system.models.dtos.CustomerDTO;
import com.gadgets.repair.system.models.dtos.TechnicianDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Technician;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class TicketResponseDTO {
    private Long id;
    private DeviceType deviceType;
    private String issueDescription;
    private Status status;
    private LocalDate createdAt;
    private LocalDate estimatedCompletionDate;
    private LocalDate completionDate;
    private CustomerDTO customerDTO; //use CustomerDTO
    private List<TechnicianDTO> technicianDTOList = new ArrayList<>(); //use TechnicianDTO
}
