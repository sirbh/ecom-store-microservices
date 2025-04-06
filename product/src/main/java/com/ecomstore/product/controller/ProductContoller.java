package com.ecomstore.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecomstore.product.dto.ProductRequest;
import com.ecomstore.product.dto.ProductResponse;
import com.ecomstore.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductContoller {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {

        return productService.createProduct(productRequest);

    }
    
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
    
}
