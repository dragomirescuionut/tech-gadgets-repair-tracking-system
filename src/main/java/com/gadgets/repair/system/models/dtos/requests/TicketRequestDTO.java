package com.gadgets.repair.system.models.dtos.requests;

import com.gadgets.repair.system.models.DeviceType;
import com.gadgets.repair.system.models.Status;

import lombok.Data;

import java.time.LocalDate;


@Data
public class TicketRequestDTO {

    private DeviceType deviceType;
    private String issueDescription;
    private Status status;
    private LocalDate created_at;
    private LocalDate estimatedCompletionDate;
    private LocalDate completionDate;
    private String customerEmail;
}
