package com.example.inventoryspring.controller;

import com.example.inventoryspring.pojo.ApiResponse;
import com.example.inventoryspring.entity.Inventory;
import com.example.inventoryspring.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService service;

    @PostMapping("/add")
    public ApiResponse<Inventory> addInventory(@RequestBody Inventory inventory) {
        return service.saveInventory(inventory);
    }

    @PostMapping("/adds")
    public ApiResponse<List<Inventory>> addInventories(@RequestBody List<Inventory> inventories) {
        return service.saveInventories(inventories);
    }

    @GetMapping("")
    public ApiResponse<List<Inventory>> findAllInventories() {
        return service.getInventories();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<Inventory> findInventoryById(@PathVariable int id) {
        return service.getInventoryById(id);
    }

    @PutMapping("/update")
    public ApiResponse<Inventory> updateInventory(@RequestBody Inventory inventory) {
        return service.updateInventory(inventory);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteInventory(@PathVariable int id) {
        return service.deleteInventory(id);
    }
}
