package com.gadgets.repair.system.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name= "address")
    private String address;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "customer")
    private List<Ticket> customerTickets;
}
