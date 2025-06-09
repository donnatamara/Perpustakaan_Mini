package controller;

import dao.BookDAO;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

@WebServlet("/admin/addBook")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String stockStr = request.getParameter("stock");
        
        String error = null;
        int stock = 0;

        // Validasi stok
        try {
            stock = Integer.parseInt(stockStr);
            if (stock < 0) {
                error = "Stok tidak boleh negatif.";
            }
        } catch (NumberFormatException e) {
            error = "Stok harus berupa angka.";
        }

        // Validasi judul dan penulis
        if (title == null || title.trim().isEmpty()) {
            error = "Judul buku wajib diisi.";
        } else if (author == null || author.trim().isEmpty()) {
            error = "Penulis wajib diisi.";
        }

        // Jika ada error, kembali ke form dengan pesan
        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("admin/addBook.jsp").forward(request, response);
            return;
        }

        // Simpan data ke database
        Book book = new Book();
        book.setId(UUID.randomUUID().toString()); // ⬅️ Tambah ID unik
        book.setTitle(title);
        book.setAuthor(author);
        book.setStock(stock);

        BookDAO bookDAO = new BookDAO();
        boolean success = bookDAO.addBook(book);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/admin/adminBooks");
        } else {
            request.setAttribute("error", "Gagal menambahkan buku.");
            request.getRequestDispatcher("admin/addBook.jsp").forward(request, response);
        }
    }
}
