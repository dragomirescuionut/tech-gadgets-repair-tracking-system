package com.gadgets.repair.system.models.dtos;

import com.gadgets.repair.system.utils.Manufacturer;
import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    private Manufacturer manufacturer;
    private String componentName;
    private Integer availableComponentQuantity;
}
