package controller;

import dao.UserDAO;
import model.Admin;
import model.Member;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String role = request.getParameter("role"); // "admin" atau "member"

        User user = UserDAO.login(id, password, role);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if (user instanceof Admin) {
                response.sendRedirect("admin/dashboard.jsp");
            } else {
                response.sendRedirect("member/book_list.jsp");
            }
        } else {
            request.setAttribute("error", "Login gagal. Cek ID dan password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
