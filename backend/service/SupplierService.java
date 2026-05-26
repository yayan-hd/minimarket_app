package com.minimarket.service;

import com.minimarket.entity.Supplier;
import com.minimarket.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }
}