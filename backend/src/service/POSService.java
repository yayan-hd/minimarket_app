package service;

import config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class POSService {

    public static void transaksi(int idKasir) {

        Scanner input = new Scanner(System.in);

        try {

            Connection conn = DBConnection.getConnection();

            double total = 0;

            while(true) {

                System.out.print("Kode Barang : ");
                String kode = input.nextLine();

                String sql =
                        "SELECT * FROM produk WHERE kode_barang=?";

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ps.setString(1, kode);

                ResultSet rs = ps.executeQuery();

                if(rs.next()) {

                    int idProduk =
                            rs.getInt("id_produk");

                    String nama =
                            rs.getString("nama_produk");

                    double harga =
                            rs.getDouble("harga_jual");

                    int stok =
                            rs.getInt("stok");

                    System.out.println(nama);
                    System.out.println("Harga : " + harga);

                    System.out.print("Qty : ");

                    int qty = input.nextInt();
                    input.nextLine();

                    if(qty > stok) {

                        System.out.println("Stok tidak cukup");
                        continue;
                    }

                    double subtotal = harga * qty;

                    total += subtotal;

                    int stokBaru = stok - qty;

                    String update =
                            "UPDATE produk SET stok=? WHERE id_produk=?";

                    PreparedStatement psUpdate =
                            conn.prepareStatement(update);

                    psUpdate.setInt(1, stokBaru);
                    psUpdate.setInt(2, idProduk);

                    psUpdate.executeUpdate();

                    System.out.println("Subtotal : " + subtotal);
                }

                System.out.print("Tambah lagi? y/n : ");

                String lagi = input.nextLine();

                if(lagi.equalsIgnoreCase("n")) {
                    break;
                }
            }

            System.out.println("Total : " + total);

            System.out.print("Bayar : ");

            double bayar = input.nextDouble();

            double kembali = bayar - total;

            System.out.println("Kembalian : " + kembali);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}