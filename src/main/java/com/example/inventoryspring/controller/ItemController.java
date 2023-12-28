package com.example.inventoryspring.controller;

import com.example.inventoryspring.Pojo.ApiResponse;
import com.example.inventoryspring.entity.Item;
import com.example.inventoryspring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping("/item/add")
    public ApiResponse<Item> addItem(@RequestBody Item item) {
        return service.saveItem(item);
    }

    @PostMapping("/item/adds")
    public ApiResponse<List<Item>> addItems(@RequestBody List<Item> items) {
        return service.saveItems(items);
    }

    @GetMapping("/item")
    public ApiResponse<List<Item>> findAllItems() {
        return service.getItems();
    }

    @GetMapping("/item/id/{id}")
    public ApiResponse<Item> findItemById(@PathVariable int id) {
        return service.getItemById(id);
    }

    @PutMapping("/item/update")
    public ApiResponse<Item> updateItem(@RequestBody Item item) {
        return service.updateItem(item);
    }

    @DeleteMapping("/item/delete/{id}")
    public ApiResponse<String> deleteItem(@PathVariable int id) {
        return service.deleteItem(id);
    }
}
