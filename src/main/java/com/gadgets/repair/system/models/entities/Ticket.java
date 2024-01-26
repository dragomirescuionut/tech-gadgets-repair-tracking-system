package com.gadgets.repair.system.models.entities;

import com.gadgets.repair.system.utils.DeviceType;
import com.gadgets.repair.system.utils.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "tickets")
@Table
@Validated
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "device_type")
    private DeviceType deviceType;
    @Column(name = "issue_description")
    private String issueDescription;
    @Column(name = "status")
    private Status status;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "estimated_completion_date")
    private LocalDate estimatedCompletionDate;
    @Column(name = "completion_date")
    private LocalDate completionDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "technician_id")
    private Technician technician;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "tickets_inventories",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id")
    )
    private List<Inventory> inventoryList;
}