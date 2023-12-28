package com.example.inventoryspring.service;

import com.example.inventoryspring.entity.Inventory;
import com.example.inventoryspring.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository repository;

    public Inventory saveInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    public List<Inventory> saveInventories(List<Inventory> inventories) {
        return repository.saveAll(inventories);
    }

    public List<Inventory> getInventories() {
        return repository.findAll();
    }

    public Inventory getInventoryById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteInventory(int id) {
        repository.deleteById(id);
        return "Inventory removed " + id;
    }

    public Inventory updateInventory(Inventory inventory) {
        Inventory existingInventory = repository.findById(inventory.getId()).orElse(null);
        existingInventory.setItem_id(inventory.getItem_id());
        existingInventory.setQuantity(inventory.getQuantity());
        existingInventory.setAcquisition_date(inventory.getAcquisition_date());
        existingInventory.setUnit_price(inventory.getUnit_price());
        existingInventory.setLocation_id(inventory.getLocation_id());
        existingInventory.setCustodian_id(inventory.getCustodian_id());
        return repository.save(existingInventory);
    }
}
