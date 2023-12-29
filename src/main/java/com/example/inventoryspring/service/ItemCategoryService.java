package com.example.inventoryspring.service;

import com.example.inventoryspring.pojo.ApiResponse;
import com.example.inventoryspring.entity.ItemCategory;
import com.example.inventoryspring.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryService {
    @Autowired
    private ItemCategoryRepository repository;

    public ApiResponse<ItemCategory> saveItemCategory(ItemCategory itemCategory) {
        try {
            ItemCategory savedItemCategory = repository.save(itemCategory);
            return new ApiResponse<>(HttpStatus.OK.value(), "Item category saved successfully", savedItemCategory);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving item category: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<ItemCategory>> saveItemCategories(List<ItemCategory> itemCategories) {
        try {
            List<ItemCategory> savedItemCategories = repository.saveAll(itemCategories);
            return new ApiResponse<>(HttpStatus.OK.value(), "Item categories saved successfully", savedItemCategories);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving item categories: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<ItemCategory>> getItemCategories() {
        try {
            List<ItemCategory> itemCategoryList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Item categories retrieved successfully", itemCategoryList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving item categories: " + e.getMessage(), null);
        }
    }

    public ApiResponse<ItemCategory> getItemCategoryById(int id) {
        try {
            ItemCategory itemCategory = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Item category retrieved successfully", itemCategory);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving item category: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteItemCategory(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Item category removed successfully", "Item category removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting item category: " + e.getMessage(), null);
        }
    }

    public ApiResponse<ItemCategory> updateItemCategory(ItemCategory itemCategory) {
        try {
            ItemCategory existingItem = repository.findById(itemCategory.getId()).orElse(null);
            existingItem.setName(itemCategory.getName());
            return new ApiResponse<>(HttpStatus.OK.value(), "Item category updated successfully", repository.save(existingItem));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating item category: " + e.getMessage(), null);
        }
    }
}
