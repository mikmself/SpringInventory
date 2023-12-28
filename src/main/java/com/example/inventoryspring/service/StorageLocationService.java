package com.example.inventoryspring.service;

import com.example.inventoryspring.entity.StorageLocation;
import com.example.inventoryspring.repository.StorageLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageLocationService {
    @Autowired
    private StorageLocationRepository repository;

    public StorageLocation saveStorageLocation(StorageLocation storageLocation) {
        return repository.save(storageLocation);
    }

    public List<StorageLocation> saveStorageLocations(List<StorageLocation> storageLocations) {
        return repository.saveAll(storageLocations);
    }

    public List<StorageLocation> getStorageLocations() {
        return repository.findAll();
    }

    public StorageLocation getStorageLocationById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteStorageLocation(int id) {
        repository.deleteById(id);
        return "Storage Location removed " + id;
    }

    public StorageLocation updateStorageLocation(StorageLocation storageLocation) {
        StorageLocation existingStorageLocation = repository.findById(storageLocation.getId()).orElse(null);
        existingStorageLocation.setName(storageLocation.getName());
        return repository.save(existingStorageLocation);
    }
}
