package com.ecomstore.inventory.dto;

public record InventoryRequest(
    String skuCode,
    Integer quantity
) {

}
