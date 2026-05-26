package com.minimarket.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produk")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produk;

    private String kode_barang;

    private String nama_produk;

    private Long id_kategori;

    private Long id_supplier;

    private BigDecimal harga_beli;

    private BigDecimal harga_jual;

    private Integer stok;

    private String satuan;

    private LocalDate expired_date;

    public Long getId_produk() {
        return id_produk;
    }

    public void setId_produk(Long id_produk) {
        this.id_produk = id_produk;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public Long getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(Long id_kategori) {
        this.id_kategori = id_kategori;
    }

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long id_supplier) {
        this.id_supplier = id_supplier;
    }

    public BigDecimal getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(BigDecimal harga_beli) {
        this.harga_beli = harga_beli;
    }

    public BigDecimal getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(BigDecimal harga_jual) {
        this.harga_jual = harga_jual;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public LocalDate getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(LocalDate expired_date) {
        this.expired_date = expired_date;
    }
}