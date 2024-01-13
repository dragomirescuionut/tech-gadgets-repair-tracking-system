package com.gadgets.repair.system.models.entities;

import com.gadgets.repair.system.models.DeviceType;
import com.gadgets.repair.system.models.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "tickets")
@Table
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "device_type")
    private DeviceType deviceType;
    @Column(name = "issue_description")
    private String issueDescription;
    @Column(name = "status")
    private Status status;
    @Column(name = "created_at")
    private LocalDate created_at;
    @Column(name = "estimated_completion_date")
    private LocalDate estimatedCompletionDate;
    @Column(name = "completion_date")
    private LocalDate completionDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tickets_technicians",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "technician_id")
    )
    private List<Technician> technicianList;
}