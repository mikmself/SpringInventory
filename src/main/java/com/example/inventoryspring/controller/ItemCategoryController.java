package com.example.inventoryspring.controller;

import com.example.inventoryspring.Pojo.ApiResponse;
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
    public ApiResponse<ItemCategory> addItemCategory(@RequestBody ItemCategory itemCategory){
        return service.saveItemCategory(itemCategory);
    }

    @PostMapping("/item-category/adds")
    public ApiResponse<List<ItemCategory>> addItemCategories(@RequestBody List<ItemCategory> itemCategories){
        return service.saveItemCategories(itemCategories);
    }

    @GetMapping("/item-category")
    public ApiResponse<List<ItemCategory>> findAllItemCategories(){
        return service.getItemCategories();
    }

    @GetMapping("/item-category/id/{id}")
    public ApiResponse<ItemCategory> findItemCategoryById(@PathVariable int id){
        return service.getItemCategoryById(id);
    }

    @PutMapping("/item-category/update")
    public ApiResponse<ItemCategory> updateItemCategory(@RequestBody ItemCategory itemCategory){
        return service.updateItemCategory(itemCategory);
    }

    @DeleteMapping("/item-category/delete/{id}")
    public ApiResponse<String> deleteItemCategory(@PathVariable int id){
        return service.deleteItemCategory(id);
    }
}
