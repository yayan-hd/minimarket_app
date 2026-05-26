package service;

import config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginService {

    public static int login() {

        Scanner input = new Scanner(System.in);

        System.out.print("Username : ");
        String username = input.nextLine();

        System.out.print("Password : ");
        String password = input.nextLine();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM kasir WHERE username=? AND password_hash=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Login berhasil");

                return rs.getInt("id_kasir");

            } else {

                System.out.println("Login gagal");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}