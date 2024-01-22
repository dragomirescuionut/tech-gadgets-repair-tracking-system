package com.gadgets.repair.system.models.dtos.responses;

import com.gadgets.repair.system.utils.Manufacturer;
import lombok.Data;

@Data
public class InventoryResponseDTO {
    private Long id;
    private Manufacturer manufacturer;
    private String componentName;
    private Integer availableComponentQuantity;
}
