package dao;

import model.Admin;
import model.Member;
import model.User;
import util.DBUtil;

import java.sql.*;

public class UserDAO {
    public static User login(String id, String password, String role) {
        Connection conn = DBUtil.getConnection();
        if (conn == null) {
            System.err.println("Gagal mendapatkan koneksi database (DBUtil.getConnection() return null)");
            return null;
        }

        User user = null;

        try {
            String query = "SELECT * FROM users WHERE id = ? AND password = ? AND role = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, role);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");

                if ("admin".equals(role)) {
                    user = new Admin(id, name, password);
                } else {
                    user = new Member(id, name, password);
                }
            }

            // Tutup resource
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return user;
    }
}
