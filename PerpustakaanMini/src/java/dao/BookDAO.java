package dao;

import model.Book;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        Connection conn = DBUtil.getConnection();

        try {
            String query = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Book book = new Book(
                    rs.getString("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("stock")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
