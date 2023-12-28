package com.example.inventoryspring.service;

import com.example.inventoryspring.entity.UsageHistory;
import com.example.inventoryspring.repository.UsageHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsageHistoryService {
    @Autowired
    private UsageHistoryRepository repository;

    public UsageHistory saveUsageHistory(UsageHistory usageHistory) {
        return repository.save(usageHistory);
    }

    public List<UsageHistory> saveUsageHistories(List<UsageHistory> usageHistories) {
        return repository.saveAll(usageHistories);
    }

    public List<UsageHistory> getUsageHistories() {
        return repository.findAll();
    }

    public UsageHistory getUsageHistoryById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteUsageHistory(int id) {
        repository.deleteById(id);
        return "Usage History removed " + id;
    }

    public UsageHistory updateUsageHistory(UsageHistory usageHistory) {
        UsageHistory existingUsageHistory = repository.findById(usageHistory.getId()).orElse(null);
        existingUsageHistory.setInventory_id(usageHistory.getInventory_id());
        existingUsageHistory.setUsage_date(usageHistory.getUsage_date());
        existingUsageHistory.setUsage_quantity(usageHistory.getUsage_quantity());
        return repository.save(existingUsageHistory);
    }
}
