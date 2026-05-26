package service;

import config.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InventoryService {

    public static void showProduk() {

        try {

            Connection conn = DBConnection.getConnection();

            Statement st = conn.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM produk");

            while(rs.next()) {

                System.out.println(
                        rs.getString("kode_barang")
                        + " | " +
                        rs.getString("nama_produk")
                        + " | Stok : " +
                        rs.getInt("stok")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}