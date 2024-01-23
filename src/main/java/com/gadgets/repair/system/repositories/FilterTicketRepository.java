package com.gadgets.repair.system.repositories;

import com.gadgets.repair.system.models.entities.Ticket;
import com.gadgets.repair.system.utils.DeviceType;
import com.gadgets.repair.system.utils.Status;

import java.util.List;

public interface FilterTicketRepository {
    List<Ticket> findFilteredTickets(Status status, DeviceType deviceType);
}