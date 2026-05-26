package com.minimarket.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_supplier;

    private String nama_supplier;
    private String kontak_person;
    private String telepon;
    private String alamat;
    private String email;

    // GETTER SETTER

    public Integer getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Integer id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getNama_supplier() {
        return nama_supplier;
    }

    public void setNama_supplier(String nama_supplier) {
        this.nama_supplier = nama_supplier;
    }

    public String getKontak_person() {
        return kontak_person;
    }

    public void setKontak_person(String kontak_person) {
        this.kontak_person = kontak_person;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}