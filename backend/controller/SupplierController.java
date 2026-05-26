package com.minimarket.controller;

import com.minimarket.entity.Supplier;
import com.minimarket.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@CrossOrigin("*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.getAll();
    }

    @PostMapping
    public Supplier save(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        supplierService.delete(id);
    }
}