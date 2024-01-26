package com.gadgets.repair.system.models.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gadgets.repair.system.models.dtos.InventoryDTO;
import com.gadgets.repair.system.models.entities.Inventory;
import com.gadgets.repair.system.utils.DeviceType;
import com.gadgets.repair.system.utils.Status;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Validated
@Data
public class TicketRequestDTO {

    private DeviceType deviceType;
    @NotBlank(message = "Issue description is required!")
    @Size(min = 10, max = 300, message = "Issue description must be between 10 and 300 characters!")
    private String issueDescription;
    private Status status;
    private LocalDate createdAt;
    @FutureOrPresent(message = "Invalid estimated completion date!")
    private LocalDate estimatedCompletionDate;
    private LocalDate completionDate;
    @NotNull(message = "Customer id is required!")
    private Long customerId;
    private Long technicianId;
    private List<InventoryDTO> inventoryList;
}
