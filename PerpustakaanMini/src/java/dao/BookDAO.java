package dao;

import model.Book;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Book book = new Book();
                book.setId(String.valueOf(rs.getInt("id"))); 
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setStock(rs.getInt("stock"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public boolean addBook(Book book) {
        String sql = "INSERT INTO books (title, author, stock) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getStock());

            int rowsInserted = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBook(Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, stock = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            int bookId = Integer.parseInt(book.getId());

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getStock());
            stmt.setInt(4, bookId);

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
            return rowsUpdated > 0;

        } catch (NumberFormatException e) {
            System.err.println("Invalid book ID format: " + book.getId());
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            System.err.println("SQL error while updating book ID: " + book.getId());
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteBookById(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
            return rowsDeleted > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting book with ID: " + id);
            e.printStackTrace();
            return false;
        }
    }

    public Book getBookById(int id) {
       String sql = "SELECT * FROM books WHERE id = ?";
       try (Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

           stmt.setInt(1, id);
           ResultSet rs = stmt.executeQuery();

           if (rs.next()) {
               Book book = new Book();
               book.setId(String.valueOf(rs.getInt("id"))); 
               book.setTitle(rs.getString("title"));
               book.setAuthor(rs.getString("author"));
               book.setStock(rs.getInt("stock"));
               return book;
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }
       return null;
   }

}
