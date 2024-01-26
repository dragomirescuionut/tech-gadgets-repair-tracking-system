package com.gadgets.repair.system.repositories.customer;

import com.gadgets.repair.system.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findByEmail(String email);
}
