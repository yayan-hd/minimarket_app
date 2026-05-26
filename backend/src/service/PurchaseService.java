package service;

import config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PurchaseService {

    public static void pembelian(int idKasir) {

        Scanner input = new Scanner(System.in);

        try {

            Connection conn = DBConnection.getConnection();

            System.out.print("ID Produk : ");
            int idProduk = input.nextInt();

            System.out.print("Qty : ");
            int qty = input.nextInt();

            String cek =
                    "SELECT stok FROM produk WHERE id_produk=?";

            PreparedStatement psCek =
                    conn.prepareStatement(cek);

            psCek.setInt(1, idProduk);

            var rs = psCek.executeQuery();

            if(rs.next()) {

                int stokLama = rs.getInt("stok");

                int stokBaru = stokLama + qty;

                String update =
                        "UPDATE produk SET stok=? WHERE id_produk=?";

                PreparedStatement psUpdate =
                        conn.prepareStatement(update);

                psUpdate.setInt(1, stokBaru);
                psUpdate.setInt(2, idProduk);

                psUpdate.executeUpdate();

                System.out.println("Pembelian berhasil");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}