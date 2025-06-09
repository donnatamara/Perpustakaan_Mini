package controller;

import dao.BookDAO;
import model.Admin;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/admin/adminBooks")
public class BookAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Validasi session dan role Admin
        HttpSession session = request.getSession(false);
        if (session == null || !(session.getAttribute("user") instanceof Admin)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Ambil daftar buku dari DAO
        List<Book> books = BookDAO.getAllBooks();

        // Tetapkan ke attribute request
        request.setAttribute("books", books);

        // Forward ke JSP
        String jspPath = "/admin/adminBooks.jsp";  // path-nya dari root Web Pages/
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}
