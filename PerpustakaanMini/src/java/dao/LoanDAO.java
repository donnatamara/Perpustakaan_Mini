package dao;

import model.Loan;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {

    public static List<Loan> getAllLoanHistory() {
    List<Loan> loans = new ArrayList<>();

    String sql = """
        SELECT b.id, u.name AS member_name, bo.title AS book_title,
               b.borrow_date, b.return_date
        FROM borrow b
        JOIN users u ON b.member_id = u.id
        JOIN books bo ON b.book_id = bo.id
        ORDER BY b.borrow_date DESC
    """;

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Loan loan = new Loan();
            loan.setId(rs.getString("id"));
            loan.setNama(rs.getString("member_name"));
            loan.setJudulBuku(rs.getString("book_title"));
            loan.setTanggalPeminjaman(rs.getDate("borrow_date"));
            loan.setTanggalKembali(rs.getDate("return_date"));
            loan.setStatus(rs.getDate("return_date") == null ? "Dipinjam" : "Dikembalikan");

            loans.add(loan);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return loans;
}


    public List<Loan> getLoansByMemberName(String nama) {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM borrow WHERE nama = ? ORDER BY borrow_date DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nama);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Loan loan = new Loan();
                loan.setId(rs.getString("ID"));
                loan.setNama(rs.getString("nama"));
                loan.setJudulBuku(rs.getString("judul_buku"));
                loan.setTanggalPeminjaman(rs.getDate("tanggal_peminjaman"));
                loan.setTanggalKembali(rs.getDate("tanggal_kembali"));
                loan.setStatus(rs.getString("status"));
                loans.add(loan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loans;
    }

    public boolean insertLoan(Loan loan) {
    String sql = "INSERT INTO borrow (id, member_id, book_id, borrow_date) VALUES (?, ?, ?, ?)";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        String borrowId = "BRW" + System.currentTimeMillis(); // ID unik sederhana
        stmt.setString(1, borrowId);
        stmt.setString(2, loan.getNama()); // sebenarnya memberId
        stmt.setString(3, loan.getJudulBuku()); // sebenarnya bookId
        stmt.setDate(4, new java.sql.Date(loan.getTanggalPeminjaman().getTime()));

        return stmt.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}


    public List<Loan> getLoansByMemberId(String memberId) {
    List<Loan> loans = new ArrayList<>();

    String sql = """
        SELECT b.id, u.name AS member_name, bo.title AS book_title,
        b.borrow_date, b.return_date
        FROM borrow b
        JOIN users u ON b.member_id = u.id
        JOIN books bo ON b.book_id = bo.id
        WHERE b.member_id = ?
        ORDER BY b.borrow_date DESC
        """;

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, memberId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Loan loan = new Loan();
            loan.setId(rs.getString("id"));
            loan.setNama(rs.getString("member_name"));
            loan.setJudulBuku(rs.getString("book_title"));
            loan.setTanggalPeminjaman(rs.getDate("borrow_date"));
            loan.setTanggalKembali(rs.getDate("return_date"));
            loan.setStatus(rs.getDate("return_date") == null ? "Dipinjam" : "Dikembalikan");

            loans.add(loan);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return loans;
}
    
    public static boolean returnBook(String loanId) {
    String sql = "UPDATE borrow SET return_date = CURRENT_DATE WHERE id = ? AND return_date IS NULL";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, loanId);
        int updated = stmt.executeUpdate();

        return updated > 0; // true jika berhasil update, false jika gagal

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
