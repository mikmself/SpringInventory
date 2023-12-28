package com.example.inventoryspring.repository;

import com.example.inventoryspring.entity.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageHistoryRepository extends JpaRepository<UsageHistory, Integer> {
}
