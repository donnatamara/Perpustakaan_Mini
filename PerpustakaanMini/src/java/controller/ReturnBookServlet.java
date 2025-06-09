package controller;

import dao.LoanDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/returnBook")
public class ReturnBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loanId = request.getParameter("loanId");

        if (loanId != null && !loanId.isEmpty()) {
            boolean success = LoanDAO.returnBook(loanId);
            // Bisa logika tambahan jika ingin simpan pesan sukses/gagal ke session
        }

        response.sendRedirect(request.getContextPath() + "/admin/adminLoanHistory");
    }
}
