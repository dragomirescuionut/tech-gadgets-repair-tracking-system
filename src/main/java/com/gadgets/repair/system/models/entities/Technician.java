package com.gadgets.repair.system.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "technicians")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "technician_name")
    private String technicianName;
    @Column(name = "contact_information")
    private String contactInformation;
    @OneToMany(mappedBy = "technician")
    private List<Assignment> assignments;
}