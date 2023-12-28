package com.example.inventoryspring.service;

import com.example.inventoryspring.entity.Custodian;
import com.example.inventoryspring.repository.CustodianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustodianService {
    @Autowired
    private CustodianRepository repository;

    public Custodian saveCustodian(Custodian custodian) {
        return repository.save(custodian);
    }

    public List<Custodian> saveCustodians(List<Custodian> custodians) {
        return repository.saveAll(custodians);
    }

    public List<Custodian> getCustodians() {
        return repository.findAll();
    }

    public Custodian getCustodianById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteCustodian(int id) {
        repository.deleteById(id);
        return "Custodian removed " + id;
    }

    public Custodian updateCustodian(Custodian custodian) {
        Custodian existingCustodian = repository.findById(custodian.getId()).orElse(null);
        existingCustodian.setName(custodian.getName());
        existingCustodian.setInfo(custodian.getInfo());
        return repository.save(existingCustodian);
    }
}
