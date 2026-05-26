package com.minimarket.repository;

import com.minimarket.entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<Produk, Integer> {

}