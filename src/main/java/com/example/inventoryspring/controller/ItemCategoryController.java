package com.example.inventoryspring.controller;

import com.example.inventoryspring.pojo.ApiResponse;
import com.example.inventoryspring.entity.ItemCategory;
import com.example.inventoryspring.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-category")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService service;

    @PostMapping("/add")
    public ApiResponse<ItemCategory> addItemCategory(@RequestBody ItemCategory itemCategory){
        return service.saveItemCategory(itemCategory);
    }

    @PostMapping("/adds")
    public ApiResponse<List<ItemCategory>> addItemCategories(@RequestBody List<ItemCategory> itemCategories){
        return service.saveItemCategories(itemCategories);
    }

    @GetMapping("")
    public ApiResponse<List<ItemCategory>> findAllItemCategories(){
        return service.getItemCategories();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<ItemCategory> findItemCategoryById(@PathVariable int id){
        return service.getItemCategoryById(id);
    }

    @PutMapping("/update")
    public ApiResponse<ItemCategory> updateItemCategory(@RequestBody ItemCategory itemCategory){
        return service.updateItemCategory(itemCategory);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteItemCategory(@PathVariable int id){
        return service.deleteItemCategory(id);
    }
}
