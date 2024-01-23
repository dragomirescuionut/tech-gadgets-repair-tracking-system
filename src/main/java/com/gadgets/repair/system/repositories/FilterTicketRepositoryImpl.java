package com.gadgets.repair.system.repositories;

import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Ticket;
import com.gadgets.repair.system.utils.DeviceType;
import com.gadgets.repair.system.utils.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class FilterTicketRepositoryImpl implements FilterTicketRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> findFilteredTickets(Status status, DeviceType deviceType) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);

        Root<Ticket> customerRoot = cq.from(Ticket.class);
        List<Predicate> predicates = new ArrayList<>();

        if (status != null) {
            predicates.add(cb.equal(customerRoot.get("status"), status));
        }
        if (deviceType != null) {
            predicates.add(cb.equal(customerRoot.get("deviceType"), deviceType));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}