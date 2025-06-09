<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Member" %>
<%@ page session="true" %>
<%
    Member member = (Member) session.getAttribute("user");
    if (member == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Member</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f2f5;
        }
        .card-dashboard {
            background-color: #ffffff;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
        }
        .navbar-brand {
            font-weight: bold;
            font-size: 1.3rem;
        }
        .nav-link {
            font-weight: 500;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">📖 Member Dashboard</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/member/memberBooks">Daftar Buku</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/member/memberLoanHistory">Peminjaman Saya</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<%= request.getContextPath() %>/logout.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Konten Utama -->
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card card-dashboard p-4 text-center">
                <h2 class="mb-3">Selamat datang, <strong><%= member.getName() %></strong> 👋</h2>
                <p class="lead text-muted">Silakan gunakan menu navigasi di atas atau di bawah untuk menjelajahi koleksi buku dan melihat riwayat peminjaman Anda.</p>
                <hr>
                <div class="d-flex justify-content-center gap-3 mt-4">
                    <a href="<%= request.getContextPath() %>/member/memberBooks" class="btn btn-primary">Lihat Buku</a>
                    <a href="<%= request.getContextPath() %>/member/memberLoanHistory" class="btn btn-outline-secondary">Peminjaman Saya</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
