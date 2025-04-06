package com.ecomstore.product.dto;

public record ProductResponse(
        Long id,
        String name,
        String description,
        Double price,
        String skuCode) {
}