package controller;

import dao.LoanDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Loan;
import model.Member;

@WebServlet("/member/memberLoanHistory")
public class MemberLoanHistoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Cek apakah user sudah login
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("../login.jsp");
            return;
        }

        Member member = (Member) session.getAttribute("user");

        // Ambil daftar pinjaman berdasarkan member ID
        LoanDAO loanDAO = new LoanDAO();
        List<Loan> loans = loanDAO.getLoansByMemberId(member.getId());

        request.setAttribute("loans", loans);
        request.getRequestDispatcher("/member/memberLoanHistory.jsp").forward(request, response);
    }
}
