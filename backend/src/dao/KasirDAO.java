package dao;

import config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class KasirDAO {

    public void insert(
            String nama,
            String username,
            String password,
            String role
    ) {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO kasir(nama_kasir,username,password_hash,role,tanggal_bergabung) VALUES(?,?,?,?,NOW())";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, nama);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, role);

            ps.executeUpdate();

            System.out.println("Kasir berhasil ditambah");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}