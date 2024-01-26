package com.gadgets.repair.system.models.dtos.requests;

import com.gadgets.repair.system.utils.Manufacturer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventoryRequestDTO {
    private Long id;
    private Manufacturer manufacturer;
    @NotBlank(message = "Invalid component name!")
    private String componentName;
    @NotNull(message = "Invalid component quantity!")
    private Integer availableComponentQuantity;
}
