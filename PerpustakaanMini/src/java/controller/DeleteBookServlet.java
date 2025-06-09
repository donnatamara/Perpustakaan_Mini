package controller;

import dao.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookId = request.getParameter("id");

        if (bookId != null && !bookId.isEmpty()) {
            try {
                int id = Integer.parseInt(bookId); 
                BookDAO dao = new BookDAO();       
                boolean success = dao.deleteBookById(id);

                if (success) {
                    response.sendRedirect(request.getContextPath() + "/admin/adminBooks?status=deleted");
                } else {
                    response.sendRedirect(request.getContextPath() + "/admin/adminBooks?status=notfound");
                }

            } catch (NumberFormatException e) {
                System.err.println("Invalid book ID format: " + bookId);
                response.sendRedirect(request.getContextPath() + "/admin/adminBooks?status=invalid");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/admin/adminBooks?status=error");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/adminBooks?status=invalid");
        }
    }
}
