package com.gadgets.repair.system.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "technician_first_name")
    private String technicianFirstName;
    @Column(name = "technician_last_name")
    private String technicianLastName;
    @Column(name = "technician_email")
    private String technicianEmail;
    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<Ticket> technicianList;
}