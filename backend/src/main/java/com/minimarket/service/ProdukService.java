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

    public Produk update(Long id, Produk produk) {

        Produk old = produkRepository.findById(id).orElseThrow();

        old.setKode_barang(produk.getKode_barang());
        old.setNama_produk(produk.getNama_produk());
        old.setHarga_jual(produk.getHarga_jual());
        old.setHarga_beli(produk.getHarga_beli());
        old.setStok(produk.getStok());
        old.setSatuan(produk.getSatuan());

        return produkRepository.save(old);
    }

    public void delete(Long id) {
        produkRepository.deleteById(id);
    }
}