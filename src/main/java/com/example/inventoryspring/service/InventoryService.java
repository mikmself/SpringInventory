package com.example.inventoryspring.service;

import com.example.inventoryspring.Pojo.ApiResponse;
import com.example.inventoryspring.entity.Inventory;
import com.example.inventoryspring.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository repository;

    public ApiResponse<Inventory> saveInventory(Inventory inventory) {
        try {
            Inventory savedInventory = repository.save(inventory);
            return new ApiResponse<>(HttpStatus.OK.value(), "Inventory saved successfully", savedInventory);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving inventory: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Inventory>> saveInventories(List<Inventory> inventories) {
        try {
            List<Inventory> savedInventories = repository.saveAll(inventories);
            return new ApiResponse<>(HttpStatus.OK.value(), "Inventories saved successfully", savedInventories);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving inventories: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Inventory>> getInventories() {
        try {
            List<Inventory> inventoryList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Inventories retrieved successfully", inventoryList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving inventories: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Inventory> getInventoryById(int id) {
        try {
            Inventory inventory = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Inventory retrieved successfully", inventory);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving inventory: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteInventory(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Inventory removed successfully", "Inventory removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting inventory: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Inventory> updateInventory(Inventory inventory) {
        try {
            Inventory existingInventory = repository.findById(inventory.getId()).orElse(null);
            existingInventory.setItem_id(inventory.getItem_id());
            existingInventory.setQuantity(inventory.getQuantity());
            existingInventory.setAcquisition_date(inventory.getAcquisition_date());
            existingInventory.setUnit_price(inventory.getUnit_price());
            existingInventory.setLocation_id(inventory.getLocation_id());
            existingInventory.setCustodian_id(inventory.getCustodian_id());
            return new ApiResponse<>(HttpStatus.OK.value(), "Inventory updated successfully", repository.save(existingInventory));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating inventory: " + e.getMessage(), null);
        }
    }
}
