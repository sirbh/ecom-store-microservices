package com.ecomstore.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomstore.product.dto.InventoryRequest;
import com.ecomstore.product.dto.InventoryResponse;

@FeignClient(name = "inventory", url = "${feign.client.config.inventory.url}")
public interface InventoryClient {
   
    @GetMapping("/api/inventory")
    boolean isInStock(@RequestParam("skuCode") String skuCode);

    @PostMapping("/api/inventory")
    InventoryResponse addInventoryItem(@RequestBody InventoryRequest inventoryRequest);
}
