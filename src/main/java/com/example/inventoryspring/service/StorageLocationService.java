package com.example.inventoryspring.service;

import com.example.inventoryspring.pojo.ApiResponse;
import com.example.inventoryspring.entity.StorageLocation;
import com.example.inventoryspring.repository.StorageLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageLocationService {
    @Autowired
    private StorageLocationRepository repository;

    public ApiResponse<StorageLocation> saveStorageLocation(StorageLocation storageLocation) {
        try {
            StorageLocation savedStorageLocation = repository.save(storageLocation);
            return new ApiResponse<>(HttpStatus.OK.value(), "Storage location saved successfully", savedStorageLocation);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving storage location: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<StorageLocation>> saveStorageLocations(List<StorageLocation> storageLocations) {
        try {
            List<StorageLocation> savedStorageLocations = repository.saveAll(storageLocations);
            return new ApiResponse<>(HttpStatus.OK.value(), "Storage locations saved successfully", savedStorageLocations);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving storage locations: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<StorageLocation>> getStorageLocations() {
        try {
            List<StorageLocation> storageLocationList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Storage locations retrieved successfully", storageLocationList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving storage locations: " + e.getMessage(), null);
        }
    }

    public ApiResponse<StorageLocation> getStorageLocationById(int id) {
        try {
            StorageLocation storageLocation = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Storage location retrieved successfully", storageLocation);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving storage location: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteStorageLocation(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Storage location removed successfully", "Storage location removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting storage location: " + e.getMessage(), null);
        }
    }

    public ApiResponse<StorageLocation> updateStorageLocation(StorageLocation storageLocation) {
        try {
            StorageLocation existingStorageLocation = repository.findById(storageLocation.getId()).orElse(null);
            existingStorageLocation.setName(storageLocation.getName());
            return new ApiResponse<>(HttpStatus.OK.value(), "Storage location updated successfully", repository.save(existingStorageLocation));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating storage location: " + e.getMessage(), null);
        }
    }
}
