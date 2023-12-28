package com.example.inventoryspring.repository;

import com.example.inventoryspring.entity.Custodian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustodianRepository extends JpaRepository<Custodian, Integer> {
}
