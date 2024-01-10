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
    @Column(name = "customer")
    private String customerContactInformation;
    @Column(name = "issue_description")
    private String issueDescription;
    @Column(name = "status")
    private Status status;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @Column(name = "estimated_completion_date")
    private LocalDate estimatedCompletionDate;
    @OneToMany(mappedBy = "ticket")
    private List<Assignment> assignments;
}