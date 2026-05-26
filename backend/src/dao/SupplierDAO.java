package dao;

import config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SupplierDAO {

    public void insert(
            String nama,
            String telepon
    ) {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO supplier(nama_supplier,telepon) VALUES(?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, nama);
            ps.setString(2, telepon);

            ps.executeUpdate();

            System.out.println("Supplier berhasil ditambah");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}