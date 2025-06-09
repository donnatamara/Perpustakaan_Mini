<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="true" %>

<c:set var="admin" value="${sessionScope.user}" />
<c:if test="${admin == null}">
    <c:redirect url="../login.jsp" />
</c:if>

<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Histori Peminjaman</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            border-radius: 12px;
        }
        .badge-status {
            font-size: 0.9em;
        }
    </style>
</head>
<body class="bg-light">

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">📘 Perpustakaan Mini</a>
        <div class="d-flex">
            <span class="navbar-text text-white me-3">
                Admin: <strong>${admin.name}</strong>
            </span>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light btn-sm">Logout</a>
        </div>
    </div>
</nav>

<!-- Konten -->
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">📋 Histori Peminjaman</h4>
        </div>
        <div class="card-body">
            <c:if test="${not empty loans}">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover align-middle text-center">
                        <thead class="table-light">
                            <tr>
                                <th>No</th>
                                <th>Nama</th>
                                <th>Judul Buku</th>
                                <th>Tanggal Pinjam</th>
                                <th>Tanggal Kembali</th>
                                <th>Status</th>
                                <th>Aksi</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="loan" items="${loans}" varStatus="status">
                                <tr>
                                    <td>${status.index + 1}</td>
                                    <td>${loan.nama}</td>
                                    <td>${loan.judulBuku}</td>
                                    <td><fmt:formatDate value="${loan.tanggalPeminjaman}" pattern="yyyy-MM-dd" /></td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${loan.tanggalKembali != null}">
                                                <fmt:formatDate value="${loan.tanggalKembali}" pattern="yyyy-MM-dd" />
                                            </c:when>
                                            <c:otherwise>
                                                <span class="text-muted">Belum dikembalikan</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <span class="badge badge-status 
                                            ${loan.status == 'Dipinjam' ? 'bg-warning text-dark' : 'bg-success'}">
                                            ${loan.status}
                                        </span>
                                    </td>
                                    <td>
                                        <c:if test="${loan.status == 'Dipinjam'}">
                                            <a href="${pageContext.request.contextPath}/admin/returnBook.jsp?loanId=${loan.id}"
                                               class="btn btn-sm btn-outline-success">
                                                Kembalikan
                                            </a>
                                        </c:if>
                                        <c:if test="${loan.status == 'Dikembalikan'}">
                                            <button class="btn btn-sm btn-secondary" disabled>
                                                Selesai
                                            </button>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <c:if test="${empty loans}">
                <div class="alert alert-info text-center" role="alert">
                    Belum ada data peminjaman yang tercatat.
                </div>
            </c:if>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
