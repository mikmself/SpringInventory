package com.example.inventoryspring.service;

import com.example.inventoryspring.entity.ItemCategory;
import com.example.inventoryspring.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryService {
    @Autowired
    private ItemCategoryRepository repository;

    public ItemCategory saveItemCategory(ItemCategory itemCategory){
        return  repository.save(itemCategory);
    }
    public List<ItemCategory> saveItemCategories(List<ItemCategory> itemCategories){
        return repository.saveAll(itemCategories);
    }
    public List<ItemCategory> getItemCategories(){
        return repository.findAll();
    }
    public ItemCategory getItemCategoryById(int id){
        return repository.findById(id).orElse(null);
    }
    public String deleteItemCategory(int id){
        repository.deleteById(id);
        return "Item removed " + id;
    }
    public ItemCategory updateItemCategory(ItemCategory itemCategory){
        ItemCategory existingItem = repository.findById(itemCategory.getId()).orElse(null);
        existingItem.setName(itemCategory.getName());
        return repository.save(existingItem);
    }
}
