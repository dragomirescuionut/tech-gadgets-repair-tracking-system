package com.gadgets.repair.system.repositories.ticket;

import com.gadgets.repair.system.models.entities.Inventory;
import com.gadgets.repair.system.models.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>, FilterTicketRepository {

}