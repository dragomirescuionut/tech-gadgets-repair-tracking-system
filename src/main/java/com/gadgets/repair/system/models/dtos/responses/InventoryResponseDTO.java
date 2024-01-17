package com.gadgets.repair.system.models.dtos.responses;

import lombok.Data;

@Data
public class InventoryResponseDTO {
    private Long id;
    private String componentName;
    private Integer availableComponentQuantity;
}
