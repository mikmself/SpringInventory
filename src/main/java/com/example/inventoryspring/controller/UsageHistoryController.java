package com.example.inventoryspring.controller;

import com.example.inventoryspring.Pojo.ApiResponse;
import com.example.inventoryspring.entity.UsageHistory;
import com.example.inventoryspring.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsageHistoryController {
    @Autowired
    private UsageHistoryService service;

    @PostMapping("/usage-history/add")
    public ApiResponse<UsageHistory> addUsageHistory(@RequestBody UsageHistory usageHistory) {
        return service.saveUsageHistory(usageHistory);
    }

    @PostMapping("/usage-history/adds")
    public ApiResponse<List<UsageHistory>> addUsageHistories(@RequestBody List<UsageHistory> usageHistories) {
        return service.saveUsageHistories(usageHistories);
    }

    @GetMapping("/usage-history")
    public ApiResponse<List<UsageHistory>> findAllUsageHistories() {
        return service.getUsageHistories();
    }

    @GetMapping("/usage-history/id/{id}")
    public ApiResponse<UsageHistory> findUsageHistoryById(@PathVariable int id) {
        return service.getUsageHistoryById(id);
    }

    @PutMapping("/usage-history/update")
    public ApiResponse<UsageHistory> updateUsageHistory(@RequestBody UsageHistory usageHistory) {
        return service.updateUsageHistory(usageHistory);
    }

    @DeleteMapping("/usage-history/delete/{id}")
    public ApiResponse<String> deleteUsageHistory(@PathVariable int id) {
        return service.deleteUsageHistory(id);
    }
}
