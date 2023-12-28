package com.example.inventoryspring.service;

import com.example.inventoryspring.Pojo.ApiResponse;
import com.example.inventoryspring.entity.Item;
import com.example.inventoryspring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public ApiResponse<Item> saveItem(Item item) {
        try {
            Item savedItem = repository.save(item);
            return new ApiResponse<>(HttpStatus.OK.value(), "Item saved successfully", savedItem);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving item: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Item>> saveItems(List<Item> items) {
        try {
            List<Item> savedItems = repository.saveAll(items);
            return new ApiResponse<>(HttpStatus.OK.value(), "Items saved successfully", savedItems);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving items: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Item>> getItems() {
        try {
            List<Item> itemList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Items retrieved successfully", itemList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving items: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Item> getItemById(int id) {
        try {
            Item item = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Item retrieved successfully", item);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving item: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteItem(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Item removed successfully", "Item removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting item: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Item> updateItem(Item item) {
        try {
            Item existingItem = repository.findById(item.getId()).orElse(null);
            existingItem.setName(item.getName());
            existingItem.setDescription(item.getDescription());
            existingItem.setCategory_id(item.getCategory_id());
            return new ApiResponse<>(HttpStatus.OK.value(), "Item updated successfully", repository.save(existingItem));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating item: " + e.getMessage(), null);
        }
    }
}
