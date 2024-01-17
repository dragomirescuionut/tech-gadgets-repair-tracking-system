package com.gadgets.repair.system.models.dtos.requests;

import com.gadgets.repair.system.models.DeviceType;
import com.gadgets.repair.system.models.Status;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;


@Data
public class TicketRequestDTO {

    private DeviceType deviceType;
    @NotBlank(message = "Issue description is required!")
    @Size(min = 10, max = 300, message = "Issue description must be between 10 and 300 characters!")
    private String issueDescription;
    private Status status;
    private LocalDate createdAt = LocalDate.now();
    @FutureOrPresent(message = "Invalid estimated completion date!")
    private LocalDate estimatedCompletionDate;
    private LocalDate completionDate;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email!")
    private String customerEmail;
}
