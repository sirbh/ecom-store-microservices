package com.ecomstore.inventory.service;

import org.springframework.stereotype.Service;

import com.ecomstore.inventory.dto.InventoryRequest;
import com.ecomstore.inventory.dto.InventoryResponse;
import com.ecomstore.inventory.models.Inventory;
import com.ecomstore.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode) {
        return inventoryRepository.existsBySkuCode(skuCode);
    }

    public InventoryResponse addInventoryItem(InventoryRequest inventoryResponse) {
        Inventory inventoryItem =  inventoryRepository.save(Inventory.builder()
                .skuCode(inventoryResponse.skuCode())
                .quantity(inventoryResponse.quantity())
                .build());

        return new InventoryResponse(
                inventoryItem.getId(),
                inventoryItem.getSkuCode(),
                inventoryItem.getQuantity()
        );

    }
    
}
