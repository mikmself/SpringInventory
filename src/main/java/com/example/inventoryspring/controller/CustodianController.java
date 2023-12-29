package com.example.inventoryspring.controller;

import com.example.inventoryspring.pojo.ApiResponse;
import com.example.inventoryspring.entity.Custodian;
import com.example.inventoryspring.service.CustodianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/custodian")
public class CustodianController {
    @Autowired
    private CustodianService service;

    @PostMapping("/add")
    public ApiResponse<Custodian> addCustodian(@RequestBody Custodian custodian) {
        return service.saveCustodian(custodian);
    }

    @PostMapping("/adds")
    public ApiResponse<List<Custodian>> addCustodians(@RequestBody List<Custodian> custodians) {
        return service.saveCustodians(custodians);
    }

    @GetMapping("")
    public ApiResponse<List<Custodian>> findAllCustodians() {
        return service.getCustodians();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<Custodian> findCustodianById(@PathVariable int id) {
        return service.getCustodianById(id);
    }

    @PutMapping("/update")
    public ApiResponse<Custodian> updateCustodian(@RequestBody Custodian custodian) {
        return service.updateCustodian(custodian);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteCustodian(@PathVariable int id) {
        return service.deleteCustodian(id);
    }
}
