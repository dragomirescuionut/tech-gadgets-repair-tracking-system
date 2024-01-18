package com.gadgets.repair.system.models.dtos.responses;

import com.gadgets.repair.system.models.Manufacturer;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class InventoryResponseDTO {
    private Long id;
    private Manufacturer manufacturer;
    private String componentName;
    private Integer availableComponentQuantity;

}
