package controller;

import model.Book;
import dao.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/member/memberBooks")
public class MemberBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("../login.jsp");
            return;
        }

        // Ambil daftar buku
        List<Book> books = BookDAO.getAllBooks();

        request.setAttribute("books", books);
        request.getRequestDispatcher("/member/memberBooks.jsp").forward(request, response);
    }
}
