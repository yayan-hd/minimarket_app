package com.minimarket.controller;

import com.minimarket.entity.Produk;
import com.minimarket.service.ProdukService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produk")
@CrossOrigin("*")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping
    public List<Produk> getAll() {
        return produkService.getAll();
    }

    @PostMapping
    public Produk create(@RequestBody Produk produk) {
        return produkService.save(produk);
    }

    @PutMapping("/{id}")
    public Produk update(
            @PathVariable Long id,
            @RequestBody Produk produk
    ) {
        return produkService.update(id, produk);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produkService.delete(id);
    }
}