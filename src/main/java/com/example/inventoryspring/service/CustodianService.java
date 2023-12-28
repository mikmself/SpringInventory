package com.example.inventoryspring.service;

import com.example.inventoryspring.Pojo.ApiResponse;
import com.example.inventoryspring.entity.Custodian;
import com.example.inventoryspring.repository.CustodianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustodianService {
    @Autowired
    private CustodianRepository repository;

    public ApiResponse<Custodian> saveCustodian(Custodian custodian) {
        try {
            Custodian savedCustodian = repository.save(custodian);
            return new ApiResponse<>(HttpStatus.OK.value(), "Custodian saved successfully", savedCustodian);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving custodian: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Custodian>> saveCustodians(List<Custodian> custodians) {
        try {
            List<Custodian> savedCustodians = repository.saveAll(custodians);
            return new ApiResponse<>(HttpStatus.OK.value(), "Custodians saved successfully", savedCustodians);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving custodians: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Custodian>> getCustodians() {
        try {
            List<Custodian> custodianList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Custodians retrieved successfully", custodianList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving custodians: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Custodian> getCustodianById(int id) {
        try {
            Custodian custodian = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Custodian retrieved successfully", custodian);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving custodian: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteCustodian(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Custodian removed successfully", "Custodian removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting custodian: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Custodian> updateCustodian(Custodian custodian) {
        try {
            Custodian existingCustodian = repository.findById(custodian.getId()).orElse(null);
            existingCustodian.setName(custodian.getName());
            existingCustodian.setInfo(custodian.getInfo());
            return new ApiResponse<>(HttpStatus.OK.value(), "Custodian updated successfully", repository.save(existingCustodian));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating custodian: " + e.getMessage(), null);
        }
    }
}
