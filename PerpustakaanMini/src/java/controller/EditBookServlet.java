package controller;

import model.Book;
import dao.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/editBook")
public class EditBookServlet extends HttpServlet {

    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO();
    }

    // Tampilkan form edit dengan data buku
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Book book = bookDAO.getBookById(id);

            if (book != null) {
                request.setAttribute("book", book);
                request.getRequestDispatcher("/admin/editBook.jsp").forward(request, response);
            } else {
                // Redirect ke servlet adminBooks kalau data gak ada
                response.sendRedirect(request.getContextPath() + "/admin/adminBooks");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/admin/adminBooks");
        }
    }

    // Proses simpan perubahan data buku
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            int stock = Integer.parseInt(request.getParameter("stock"));

            // Validasi sederhana
            if (title == null || title.trim().isEmpty() ||
                author == null || author.trim().isEmpty() ||
                stock < 0) {
                request.setAttribute("error", "Harap isi semua kolom dengan benar.");
                Book book = bookDAO.getBookById(id);
                request.setAttribute("book", book);
                request.getRequestDispatcher("/admin/editBook.jsp").forward(request, response);
                return;
            }

            // Update data
            Book book = new Book(id, title, author, stock);
            boolean success = bookDAO.updateBook(book);

            if (success) {
                response.sendRedirect(request.getContextPath() + "/admin/adminBooks?success=update");
            } else {
                request.setAttribute("book", book);
                request.setAttribute("error", "Gagal menyimpan perubahan.");
                request.getRequestDispatcher("/admin/editBook.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Terjadi kesalahan saat memproses data.");
            request.getRequestDispatcher("/admin/editBook.jsp").forward(request, response);
        }
    }
}
