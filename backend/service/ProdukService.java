package com.minimarket.service;

import com.minimarket.entity.Produk;
import com.minimarket.repository.ProdukRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdukService {

    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> getAll() {
        return produkRepository.findAll();
    }

    public Produk save(Produk produk) {
        return produkRepository.save(produk);
    }

    public void delete(Integer id) {
        produkRepository.deleteById(id);
    }
}