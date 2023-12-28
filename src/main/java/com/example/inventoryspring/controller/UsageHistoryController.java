package com.example.inventoryspring.controller;

import com.example.inventoryspring.entity.UsageHistory;
import com.example.inventoryspring.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsageHistoryController {
    @Autowired
    private UsageHistoryService service;

    @PostMapping("/usageHistory/add")
    public UsageHistory addUsageHistory(@RequestBody UsageHistory usageHistory) {
        return service.saveUsageHistory(usageHistory);
    }

    @PostMapping("/usageHistory/adds")
    public List<UsageHistory> addUsageHistories(@RequestBody List<UsageHistory> usageHistories) {
        return service.saveUsageHistories(usageHistories);
    }

    @GetMapping("/usageHistory")
    public List<UsageHistory> findAllUsageHistories() {
        return service.getUsageHistories();
    }

    @GetMapping("/usageHistory/id/{id}")
    public UsageHistory findUsageHistoryById(@PathVariable int id) {
        return service.getUsageHistoryById(id);
    }

    @PutMapping("/usageHistory/update")
    public UsageHistory updateUsageHistory(@RequestBody UsageHistory usageHistory) {
        return service.updateUsageHistory(usageHistory);
    }

    @DeleteMapping("/usageHistory/delete/{id}")
    public String deleteUsageHistory(@PathVariable int id) {
        return service.deleteUsageHistory(id);
    }
}
