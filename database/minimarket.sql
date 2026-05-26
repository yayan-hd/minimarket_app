CREATE TABLE kategori (
    id_kategori INT AUTO_INCREMENT PRIMARY KEY,
    nama_kategori VARCHAR(100),
    deskripsi TEXT
);
CREATE TABLE supplier (
    id_supplier INT AUTO_INCREMENT PRIMARY KEY,
    nama_supplier VARCHAR(100),
    kontak_person VARCHAR(100),
    telepon VARCHAR(20),
    alamat TEXT,
    email VARCHAR(100)
);
CREATE TABLE kasir (
    id_kasir INT AUTO_INCREMENT PRIMARY KEY,
    nama_kasir VARCHAR(100),
    username VARCHAR(50) UNIQUE,
    password_hash VARCHAR(255),
    role VARCHAR(50),
    tanggal_bergabung DATE
);
CREATE TABLE produk (
    id_produk INT AUTO_INCREMENT PRIMARY KEY,
    kode_barang VARCHAR(50) UNIQUE,
    nama_produk VARCHAR(100),
    id_kategori INT,
    id_supplier INT,
    harga_beli DECIMAL(15,2),
    harga_jual DECIMAL(15,2),
    stok INT,
    satuan VARCHAR(20),
    expired_date DATE,

    FOREIGN KEY (id_kategori) REFERENCES kategori(id_kategori),
    FOREIGN KEY (id_supplier) REFERENCES supplier(id_supplier)
);
CREATE TABLE penjualan (
    id_penjualan INT AUTO_INCREMENT PRIMARY KEY,
    tanggal DATETIME,
    id_kasir INT,
    total_harga DECIMAL(15,2),
    bayar DECIMAL(15,2),
    kembalian DECIMAL(15,2),
    status VARCHAR(50),

    FOREIGN KEY (id_kasir) REFERENCES kasir(id_kasir)
);
CREATE TABLE detail_penjualan (
    id_detail_penjualan INT AUTO_INCREMENT PRIMARY KEY,
    id_penjualan INT,
    id_produk INT,
    qty INT,
    harga_saat_transaksi DECIMAL(15,2),
    subtotal DECIMAL(15,2),

    FOREIGN KEY (id_penjualan) REFERENCES penjualan(id_penjualan),
    FOREIGN KEY (id_produk) REFERENCES produk(id_produk)
);
CREATE TABLE pembelian (
    id_pembelian INT AUTO_INCREMENT PRIMARY KEY,
    tanggal DATETIME,
    id_supplier INT,
    id_kasir INT,
    total DECIMAL(15,2),
    status VARCHAR(50),

    FOREIGN KEY (id_supplier) REFERENCES supplier(id_supplier),
    FOREIGN KEY (id_kasir) REFERENCES kasir(id_kasir)
);
CREATE TABLE detail_pembelian (
    id_detail_pembelian INT AUTO_INCREMENT PRIMARY KEY,
    id_pembelian INT,
    id_produk INT,
    qty INT,
    harga_beli_saat_transaksi DECIMAL(15,2),
    subtotal DECIMAL(15,2),

    FOREIGN KEY (id_pembelian) REFERENCES pembelian(id_pembelian),
    FOREIGN KEY (id_produk) REFERENCES produk(id_produk)
);
CREATE TABLE pembayaran (
    id_pembayaran INT AUTO_INCREMENT PRIMARY KEY,
    id_penjualan INT,
    tanggal_pembayaran DATETIME,
    metode VARCHAR(50),
    jumlah_dibayar DECIMAL(15,2),
    status VARCHAR(50),

    FOREIGN KEY (id_penjualan) REFERENCES penjualan(id_penjualan)
);
CREATE TABLE stok_log (
    id_stok_log INT AUTO_INCREMENT PRIMARY KEY,
    id_produk INT,
    id_kasir INT,
    tanggal DATETIME,
    jenis_mutasi VARCHAR(50),
    qty_sebelum INT,
    qty_perubahan INT,
    qty_sesudah INT,
    sumber_referensi VARCHAR(100),
    keterangan TEXT,

    FOREIGN KEY (id_produk) REFERENCES produk(id_produk),
    FOREIGN KEY (id_kasir) REFERENCES kasir(id_kasir)
);
