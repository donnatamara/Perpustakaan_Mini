package controller;

import dao.LoanDAO;
import model.Admin;
import model.Loan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/adminLoanHistory")
public class AdminLoansHistoryServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Admin admin = (session != null && session.getAttribute("user") instanceof Admin)
                ? (Admin) session.getAttribute("user") : null;

        if (admin == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        List<Loan> loans = LoanDAO.getAllLoanHistory();
        request.setAttribute("loans", loans);
        request.getRequestDispatcher("/admin/adminLoanHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loanId = request.getParameter("loanId");

        if (loanId != null && !loanId.isEmpty()) {
            LoanDAO.returnBook(loanId);  // Fungsi akan kita buat di LoanDAO
        }

        // Refresh halaman
        response.sendRedirect(request.getContextPath() + "/admin/adminLoanHistory");
    }
}
