package com.example.inventoryspring.controller;

import com.example.inventoryspring.Pojo.ApiResponse;
import com.example.inventoryspring.entity.Inventory;
import com.example.inventoryspring.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService service;

    @PostMapping("/inventory/add")
    public ApiResponse<Inventory> addInventory(@RequestBody Inventory inventory) {
        return service.saveInventory(inventory);
    }

    @PostMapping("/inventory/adds")
    public ApiResponse<List<Inventory>> addInventories(@RequestBody List<Inventory> inventories) {
        return service.saveInventories(inventories);
    }

    @GetMapping("/inventory")
    public ApiResponse<List<Inventory>> findAllInventories() {
        return service.getInventories();
    }

    @GetMapping("/inventory/id/{id}")
    public ApiResponse<Inventory> findInventoryById(@PathVariable int id) {
        return service.getInventoryById(id);
    }

    @PutMapping("/inventory/update")
    public ApiResponse<Inventory> updateInventory(@RequestBody Inventory inventory) {
        return service.updateInventory(inventory);
    }

    @DeleteMapping("/inventory/delete/{id}")
    public ApiResponse<String> deleteInventory(@PathVariable int id) {
        return service.deleteInventory(id);
    }
}
