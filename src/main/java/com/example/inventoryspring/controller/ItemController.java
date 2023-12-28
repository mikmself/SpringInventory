package com.example.inventoryspring.controller;

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
    public Item addItem(@RequestBody Item item){
        return service.saveItem(item);
    }
    @PostMapping("/item/adds")
    public List<Item> addItems(@RequestBody List<Item> items){
        return service.saveItems(items);
    }
    @GetMapping("/item")
    public List<Item> findAllItems(){
        return service.getItems();
    }
    @GetMapping("/item/id/{id}")
    public Item findItemtById(@PathVariable int id){
        return service.getItemById(id);
    }
    @PutMapping("/item/update")
    public Item updateItem(@RequestBody Item item){
        return service.updateItem(item);
    }
    @DeleteMapping("/item/delete/{id}")
    public String deleteItem(@PathVariable int id){
        return service.deleteItem(id);
    }
}