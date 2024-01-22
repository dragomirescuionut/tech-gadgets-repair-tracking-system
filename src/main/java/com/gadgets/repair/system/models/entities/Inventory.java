package com.gadgets.repair.system.models.entities;

import com.gadgets.repair.system.utils.Manufacturer;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "component_manufacturer")
    private Manufacturer manufacturer;
    @Column(name = "component_name")
    private String componentName;
    @Column(name = "available_component_quantity")
    private Integer availableComponentQuantity;
}