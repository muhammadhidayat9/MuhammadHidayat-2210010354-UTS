package controller;

import model.Catatan;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatatanController {

    // CREATE: Tambahkan catatan baru
    public void createCatatan(Catatan catatan) throws SQLException {
        String query = "INSERT INTO catatan (judul, tanggal, isi) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, catatan.getJudul());
            stmt.setString(2, catatan.getTanggal());
            stmt.setString(3, catatan.getIsi());
            stmt.executeUpdate();
        }
    }

    // READ: Ambil semua catatan
    public List<Catatan> getAllCatatan() throws SQLException {
        List<Catatan> catatanList = new ArrayList<>();
        String query = "SELECT * FROM catatan";

        try (Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Catatan catatan = new Catatan(
                        rs.getInt("id"),
                        rs.getString("judul"),
                        rs.getString("tanggal"),
                        rs.getString("isi")
                );
                catatanList.add(catatan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return catatanList;
    }

    // UPDATE: Ubah catatan berdasarkan ID
    public void updateCatatan(Catatan catatan) throws SQLException {
        String query = "UPDATE catatan SET judul = ?, tanggal = ?, isi = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, catatan.getJudul());
            stmt.setString(2, catatan.getTanggal());
            stmt.setString(3, catatan.getIsi());
            stmt.setInt(4, catatan.getId());
            stmt.executeUpdate();
        }
    }

    // DELETE: Hapus catatan berdasarkan ID
    public void deleteCatatan(int id) throws SQLException {
        String query = "DELETE FROM catatan WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // SEARCH: Cari catatan berdasarkan judul atau isi
    public List<Catatan> searchCatatan(String keyword) throws SQLException {
        List<Catatan> catatanList = new ArrayList<>();
        String query = "SELECT * FROM catatan WHERE judul LIKE ? OR isi LIKE ?";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Catatan catatan = new Catatan(
                        rs.getInt("id"),
                        rs.getString("judul"),
                        rs.getString("tanggal"),
                        rs.getString("isi")
                );
                catatanList.add(catatan);
            }
        }
        return catatanList;
    }
}
