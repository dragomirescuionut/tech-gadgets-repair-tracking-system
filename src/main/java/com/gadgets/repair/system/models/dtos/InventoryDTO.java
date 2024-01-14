package com.gadgets.repair.system.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    @NotBlank(message = "Invalid component name")
    private String componentName;
    @NotNull(message = "Invalid component quantity")
    private Integer availableComponentQuantity;
}
