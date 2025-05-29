package controller;

import dao.BookDAO;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        List<Book> books = BookDAO.getAllBooks();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member/book_list.jsp");
        dispatcher.forward(request, response);
    }
}
