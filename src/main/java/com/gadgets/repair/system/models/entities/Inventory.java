package com.gadgets.repair.system.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "component_name")
    private String componentName;
    @Column(name = "available_quantity")
    private Integer availableQuantity;
}