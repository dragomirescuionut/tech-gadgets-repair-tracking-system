package com.gadgets.repair.system.models.dtos;

import com.gadgets.repair.system.models.entities.Ticket;

import java.time.LocalDate;
import java.util.List;

public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    private List<Ticket> customerTickets;
}
