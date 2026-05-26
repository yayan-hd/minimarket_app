package com.minimarket.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "produk")
public class Produk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produk;

    private String kode_barang;
    private String nama_produk;

    private BigDecimal harga_beli;
    private BigDecimal harga_jual;

    private Integer stok;

    private String satuan;

    @Temporal(TemporalType.DATE)
    private Date expired_date;

    // GETTER SETTER

    public Integer getId_produk() {
        return id_produk;
    }

    public void setId_produk(Integer id_produk) {
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

    public Date getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(Date expired_date) {
        this.expired_date = expired_date;
    }
}