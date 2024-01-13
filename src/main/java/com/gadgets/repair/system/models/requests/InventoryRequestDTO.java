package com.gadgets.repair.system.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventoryRequestDTO {

    @NotBlank(message = "Invalid component name")
    private String componentName;
    @NotNull(message = "Invalid component quantity")
    private Integer availableComponentQuantity;
}
