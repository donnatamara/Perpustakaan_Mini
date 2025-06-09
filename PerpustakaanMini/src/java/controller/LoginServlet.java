package controller;

import dao.UserDAO;
import model.Admin;
import model.Member;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if (id == null || id.isEmpty() || password == null || password.isEmpty() || role == null) {
            request.setAttribute("error", "Semua field harus diisi.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        User user = UserDAO.login(id, password, role);

        if (user != null) {
            // Invalidate old session if exists
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            // Create new session
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getId());   // ⬅️ Penting untuk semua servlet yang butuh id
            session.setAttribute("role", role);

            // Redirect based on role
            if (user instanceof Admin) {
                response.sendRedirect(request.getContextPath() + "/admin/adminDashboard.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/member/memberDashboard.jsp");
            }
        } else {
            request.setAttribute("error", "Login gagal. Cek ID dan password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
