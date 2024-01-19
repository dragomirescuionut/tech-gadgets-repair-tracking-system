package com.gadgets.repair.system.models.dtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    //private List<Ticket> customerTickets;
}
