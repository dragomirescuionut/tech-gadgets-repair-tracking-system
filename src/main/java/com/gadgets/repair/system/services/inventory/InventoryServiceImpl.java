package com.gadgets.repair.system.services.inventory;

import com.gadgets.repair.system.models.dtos.requests.InventoryRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.InventoryResponseDTO;
import com.gadgets.repair.system.models.entities.Inventory;
import com.gadgets.repair.system.repositories.inventory.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, ModelMapper modelMapper) {
        this.inventoryRepository = inventoryRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public InventoryResponseDTO createInventoryItem(InventoryRequestDTO inventoryRequestDTO) {
        Inventory savedInventory = inventoryRepository.save(modelMapper.map(inventoryRequestDTO, Inventory.class));
        log.info("Inventory item with id {} saved in data base", savedInventory.getId());
        return modelMapper.map(savedInventory, InventoryResponseDTO.class);
    }
}