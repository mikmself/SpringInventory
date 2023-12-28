package com.example.inventoryspring.controller;

import com.example.inventoryspring.Pojo.ApiResponse;
import com.example.inventoryspring.entity.StorageLocation;
import com.example.inventoryspring.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StorageLocationController {
    @Autowired
    private StorageLocationService service;

    @PostMapping("/storage-location/add")
    public ApiResponse<StorageLocation> addStorageLocation(@RequestBody StorageLocation storageLocation) {
        return service.saveStorageLocation(storageLocation);
    }

    @PostMapping("/storage-location/adds")
    public ApiResponse<List<StorageLocation>> addStorageLocations(@RequestBody List<StorageLocation> storageLocations) {
        return service.saveStorageLocations(storageLocations);
    }

    @GetMapping("/storage-location")
    public ApiResponse<List<StorageLocation>> findAllStorageLocations() {
        return service.getStorageLocations();
    }

    @GetMapping("/storage-location/id/{id}")
    public ApiResponse<StorageLocation> findStorageLocationById(@PathVariable int id) {
        return service.getStorageLocationById(id);
    }

    @PutMapping("/storage-location/update")
    public ApiResponse<StorageLocation> updateStorageLocation(@RequestBody StorageLocation storageLocation) {
        return service.updateStorageLocation(storageLocation);
    }

    @DeleteMapping("/storage-location/delete/{id}")
    public ApiResponse<String> deleteStorageLocation(@PathVariable int id) {
        return service.deleteStorageLocation(id);
    }
}
