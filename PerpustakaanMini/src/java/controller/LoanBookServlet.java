package controller;

import dao.LoanDAO;
import model.Loan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/member/loanBook")
public class LoanBookServlet extends HttpServlet {

    private final LoanDAO loanDAO = new LoanDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String memberId = (String) session.getAttribute("userId");
        String bookId = request.getParameter("bookId");

        if (bookId == null || bookId.isEmpty()) {
            request.setAttribute("error", "ID buku tidak valid.");
            request.getRequestDispatcher("/member/memberBooks.jsp").forward(request, response);
            return;
        }

        Loan loan = new Loan();
        loan.setNama(memberId);
        loan.setJudulBuku(bookId);
        loan.setTanggalPeminjaman(new Date());
        loan.setTanggalKembali(null);

        boolean success = loanDAO.insertLoan(loan);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/member/memberLoanHistory");
        } else {
            request.setAttribute("error", "Gagal meminjam buku.");
            request.getRequestDispatcher("/member/memberBooks").forward(request, response);
        }
    }
}
