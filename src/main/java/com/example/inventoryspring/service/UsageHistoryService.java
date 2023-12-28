package com.example.inventoryspring.service;

import com.example.inventoryspring.Pojo.ApiResponse;
import com.example.inventoryspring.entity.UsageHistory;
import com.example.inventoryspring.repository.UsageHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsageHistoryService {
    @Autowired
    private UsageHistoryRepository repository;

    public ApiResponse<UsageHistory> saveUsageHistory(UsageHistory usageHistory) {
        try {
            UsageHistory savedUsageHistory = repository.save(usageHistory);
            return new ApiResponse<>(HttpStatus.OK.value(), "Usage history saved successfully", savedUsageHistory);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error saving usage history: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<UsageHistory>> saveUsageHistories(List<UsageHistory> usageHistories) {
        try {
            List<UsageHistory> savedUsageHistories = repository.saveAll(usageHistories);
            return new ApiResponse<>(HttpStatus.OK.value(), "Usage histories saved successfully", savedUsageHistories);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error saving usage histories: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<UsageHistory>> getUsageHistories() {
        try {
            List<UsageHistory> usageHistoryList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Usage histories retrieved successfully", usageHistoryList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error retrieving usage histories: " + e.getMessage(), null);
        }
    }

    public ApiResponse<UsageHistory> getUsageHistoryById(int id) {
        try {
            UsageHistory usageHistory = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Usage history retrieved successfully", usageHistory);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error retrieving usage history: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteUsageHistory(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Usage history removed successfully", "Usage history removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error deleting usage history: " + e.getMessage(), null);
        }
    }

    public ApiResponse<UsageHistory> updateUsageHistory(UsageHistory usageHistory) {
        try {
            UsageHistory existingUsageHistory = repository.findById(usageHistory.getId()).orElse(null);
            if (existingUsageHistory != null) {
                existingUsageHistory.setInventory_id(usageHistory.getInventory_id());
                existingUsageHistory.setUsage_date(usageHistory.getUsage_date());
                existingUsageHistory.setUsage_quantity(usageHistory.getUsage_quantity());
                return new ApiResponse<>(HttpStatus.OK.value(), "Usage history updated successfully", repository.save(existingUsageHistory));
            } else {
                return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Usage history not found", null);
            }
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error updating usage history: " + e.getMessage(), null);
        }
    }
}
