package com.example.inventoryspring.controller;

import com.example.inventoryspring.entity.Item;
import com.example.inventoryspring.entity.ItemCategory;
import com.example.inventoryspring.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService service;
    @PostMapping("/item-category/add")
    public ItemCategory addItemCategories(@RequestBody ItemCategory itemCategory){
        return service.saveItemCategory(itemCategory);
    }
    @PostMapping("/item-category/adds")
    public List<ItemCategory> addItems(@RequestBody List<ItemCategory> itemsCategories){
        return service.saveItemCategories(itemsCategories);
    }
    @GetMapping("/item-category")
    public List<ItemCategory> findAllItems(){
        return service.getItemCategories();
    }
    @GetMapping("/item-category/id/{id}")
    public ItemCategory findItemtById(@PathVariable int id){
        return service.getItemCategoryById(id);
    }
    @PutMapping("/item-category/update")
    public ItemCategory updateItem(@RequestBody ItemCategory itemCategory){
        return service.updateItemCategory(itemCategory);
    }
    @DeleteMapping("/item-category/delete/{id}")
    public String deleteItem(@PathVariable int id){
        return service.deleteItemCategory(id);
    }
}
