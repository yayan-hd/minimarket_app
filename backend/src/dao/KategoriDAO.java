package dao;

import config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class KategoriDAO {

    public void insert(
            String nama,
            String deskripsi
    ) {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO kategori(nama_kategori,deskripsi) VALUES(?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, nama);
            ps.setString(2, deskripsi);

            ps.executeUpdate();

            System.out.println("Kategori berhasil ditambah");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}