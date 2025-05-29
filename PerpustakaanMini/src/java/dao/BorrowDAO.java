package dao;

import model.Borrow;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowDAO {

    public static boolean addBorrow(Borrow borrow) {
        Connection conn = DBUtil.getConnection();

        try {
            String sql = "INSERT INTO borrow (id, member_id, book_id, borrow_date, return_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, borrow.getId());
            ps.setString(2, borrow.getMemberId());
            ps.setString(3, borrow.getBookId());
            ps.setDate(4, new java.sql.Date(borrow.getBorrowDate().getTime()));
            ps.setDate(5, new java.sql.Date(borrow.getReturnDate().getTime()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Borrow> getBorrowByMember(String memberId) {
        List<Borrow> borrowList = new ArrayList<>();
        Connection conn = DBUtil.getConnection();

        try {
            String sql = "SELECT * FROM borrow WHERE member_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Borrow borrow = new Borrow(
                    rs.getString("id"),
                    rs.getString("member_id"),
                    rs.getString("book_id"),
                    rs.getDate("borrow_date"),
                    rs.getDate("return_date")
                );
                borrowList.add(borrow);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowList;
    }
}
