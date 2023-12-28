package com.example.inventoryspring.controller;

import com.example.inventoryspring.entity.StorageLocation;
import com.example.inventoryspring.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StorageLocationController {
    @Autowired
    private StorageLocationService service;

    @PostMapping("/storageLocation/add")
    public StorageLocation addStorageLocation(@RequestBody StorageLocation storageLocation) {
        return service.saveStorageLocation(storageLocation);
    }

    @PostMapping("/storageLocation/adds")
    public List<StorageLocation> addStorageLocations(@RequestBody List<StorageLocation> storageLocations) {
        return service.saveStorageLocations(storageLocations);
    }

    @GetMapping("/storageLocation")
    public List<StorageLocation> findAllStorageLocations() {
        return service.getStorageLocations();
    }

    @GetMapping("/storageLocation/id/{id}")
    public StorageLocation findStorageLocationById(@PathVariable int id) {
        return service.getStorageLocationById(id);
    }

    @PutMapping("/storageLocation/update")
    public StorageLocation updateStorageLocation(@RequestBody StorageLocation storageLocation) {
        return service.updateStorageLocation(storageLocation);
    }

    @DeleteMapping("/storageLocation/delete/{id}")
    public String deleteStorageLocation(@PathVariable int id) {
        return service.deleteStorageLocation(id);
    }
}
