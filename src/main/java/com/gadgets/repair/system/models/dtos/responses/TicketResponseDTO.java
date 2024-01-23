package com.gadgets.repair.system.models.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gadgets.repair.system.utils.DeviceType;
import com.gadgets.repair.system.utils.Status;
import com.gadgets.repair.system.models.dtos.CustomerDTO;
import com.gadgets.repair.system.models.dtos.TechnicianDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TicketResponseDTO {
    private Long id;
    private DeviceType deviceType;
    private String issueDescription;
    private Status status;
    private LocalDate createdAt;
    private LocalDate estimatedCompletionDate;
    private LocalDate completionDate;
    private CustomerDTO customer;
    private TechnicianDTO technician;
}