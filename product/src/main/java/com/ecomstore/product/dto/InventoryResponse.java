package com.ecomstore.product.dto;

public record InventoryResponse(
    Long id,
    String skuCode,
    Integer quantity
) {
    
}
