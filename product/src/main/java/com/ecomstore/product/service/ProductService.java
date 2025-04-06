package com.ecomstore.product.service;

import java.util.List;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomstore.product.client.InventoryClient;
import com.ecomstore.product.dto.InventoryRequest;
import com.ecomstore.product.dto.InventoryResponse;
import com.ecomstore.product.dto.ProductRequest;
import com.ecomstore.product.dto.ProductResponse;
import com.ecomstore.product.model.Product;
import com.ecomstore.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final InventoryClient inventoryClient;

    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productRepository.save(Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .skuCode(productRequest.skuCode())
                .build());

        inventoryClient.addInventoryItem(new InventoryRequest(
                productRequest.skuCode(),
                50));


        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSkuCode());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSkuCode())).toList();

    }
}
