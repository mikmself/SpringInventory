package com.example.inventoryspring.controller;

import com.example.inventoryspring.pojo.ApiResponse;
import com.example.inventoryspring.entity.UsageHistory;
import com.example.inventoryspring.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usage-history")
public class UsageHistoryController {
    @Autowired
    private UsageHistoryService service;

    @PostMapping("/add")
    public ApiResponse<UsageHistory> addUsageHistory(@RequestBody UsageHistory usageHistory) {
        return service.saveUsageHistory(usageHistory);
    }

    @PostMapping("/adds")
    public ApiResponse<List<UsageHistory>> addUsageHistories(@RequestBody List<UsageHistory> usageHistories) {
        return service.saveUsageHistories(usageHistories);
    }

    @GetMapping("")
    public ApiResponse<List<UsageHistory>> findAllUsageHistories() {
        return service.getUsageHistories();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<UsageHistory> findUsageHistoryById(@PathVariable int id) {
        return service.getUsageHistoryById(id);
    }

    @PutMapping("/update")
    public ApiResponse<UsageHistory> updateUsageHistory(@RequestBody UsageHistory usageHistory) {
        return service.updateUsageHistory(usageHistory);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteUsageHistory(@PathVariable int id) {
        return service.deleteUsageHistory(id);
    }
}
