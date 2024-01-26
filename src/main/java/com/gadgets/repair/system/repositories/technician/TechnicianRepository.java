package com.gadgets.repair.system.repositories.technician;

import com.gadgets.repair.system.models.entities.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    Technician findByTechnicianEmail(String email);
}