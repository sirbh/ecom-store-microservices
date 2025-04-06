package com.ecomstore.product.dto;

public record ProductRequest(
        String name,
        String description,
        Double price,
        String skuCode) {
}
