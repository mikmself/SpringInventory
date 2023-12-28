package com.example.inventoryspring.repository;

import com.example.inventoryspring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
