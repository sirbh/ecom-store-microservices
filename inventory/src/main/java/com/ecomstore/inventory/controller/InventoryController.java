package com.ecomstore.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomstore.inventory.dto.InventoryRequest;
import com.ecomstore.inventory.dto.InventoryResponse;
import com.ecomstore.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
 
    private final InventoryService inventoryService;

    @GetMapping
    public boolean isInStock(@RequestParam String skuCode) {
        return inventoryService.isInStock(skuCode);
    }

    @PostMapping
    public InventoryResponse addInventoryItem(@RequestBody InventoryRequest inventoryRequest) {
        return inventoryService.addInventoryItem(inventoryRequest);
    }
}
