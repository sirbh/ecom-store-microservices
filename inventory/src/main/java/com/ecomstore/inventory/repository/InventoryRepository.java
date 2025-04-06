package com.ecomstore.inventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomstore.inventory.models.Inventory;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    public boolean existsBySkuCode(String skuCode);

} 