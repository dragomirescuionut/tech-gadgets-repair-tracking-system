package com.gadgets.repair.system.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    @Column(name = "assignment_date")
    private LocalDate assignmentDate;
}
