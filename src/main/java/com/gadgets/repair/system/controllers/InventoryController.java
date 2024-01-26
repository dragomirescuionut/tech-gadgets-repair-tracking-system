package com.gadgets.repair.system.controllers;

import com.gadgets.repair.system.models.dtos.requests.InventoryRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.InventoryResponseDTO;
import com.gadgets.repair.system.services.inventory.InventoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
    private final InventoryServiceImpl inventoryService;

    public InventoryController(InventoryServiceImpl inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<InventoryResponseDTO> createInventoryItem(@Valid @RequestBody InventoryRequestDTO inventoryRequestDTO){
        return ResponseEntity.ok(inventoryService.createInventoryItem(inventoryRequestDTO));
    }
}
