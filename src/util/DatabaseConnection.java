package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/db_catatan";
            String user = "root"; // Sesuaikan dengan username MySQL Anda
            String password = ""; // Sesuaikan dengan password MySQL Anda
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi berhasil!");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Koneksi gagal: " + e.getMessage());
            return null;
        }
    }
}
