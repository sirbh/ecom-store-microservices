package com.ecomstore.inventory.dto;

public record InventoryResponse(
    Long id,
    String skuCode,
    Integer quantity
) {
    
}
