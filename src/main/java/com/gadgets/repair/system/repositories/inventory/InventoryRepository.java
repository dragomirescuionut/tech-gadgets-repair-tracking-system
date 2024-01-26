package com.gadgets.repair.system.repositories.inventory;

import com.gadgets.repair.system.models.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    List<Inventory> findByIdIn(List<Long>ids);
}