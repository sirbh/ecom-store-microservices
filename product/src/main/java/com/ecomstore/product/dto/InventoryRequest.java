package com.ecomstore.product.dto;

public record InventoryRequest(
    String skuCode,
    Integer quantity
) {

}
