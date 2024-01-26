package com.gadgets.repair.system.services.inventory;

import com.gadgets.repair.system.models.dtos.requests.InventoryRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.InventoryResponseDTO;

public interface InventoryService {
    InventoryResponseDTO createInventoryItem(InventoryRequestDTO inventoryRequestDTO);
}
