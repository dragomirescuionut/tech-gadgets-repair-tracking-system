package com.gadgets.repair.system.models.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gadgets.repair.system.utils.DeviceType;
import com.gadgets.repair.system.utils.Status;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Validated
@Data
public class TicketRequestDTO {
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private DeviceType deviceType;
    @NotBlank(message = "Issue description is required!")
    @Size(min = 10, max = 300, message = "Issue description must be between 10 and 300 characters!")
    private String issueDescription;
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Status status;
    private LocalDate createdAt;
    @FutureOrPresent(message = "Invalid estimated completion date!")
    private LocalDate estimatedCompletionDate;
    private LocalDate completionDate;
    @NotNull(message = "Customer id is required!")
    private Long customerId;
    private Long technicianId;
}
