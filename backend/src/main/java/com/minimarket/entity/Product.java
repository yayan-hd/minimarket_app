package com.minimarket.entity;
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