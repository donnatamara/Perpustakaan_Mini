<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<c:set var="admin" value="${sessionScope.user}" />
<c:if test="${admin == null}">
    <c:redirect url="../login.jsp" />
</c:if>

<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Konfirmasi Pengembalian</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

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

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-warning text-dark">
            <h4 class="mb-0">Konfirmasi Pengembalian Buku</h4>
        </div>
        <div class="card-body">
            <p>Apakah Anda yakin ingin mengembalikan buku dengan ID peminjaman berikut?</p>
            <p><strong>ID Peminjaman:</strong> ${param.loanId}</p>

            <form method="post" action="${pageContext.request.contextPath}/admin/returnBook">
                <input type="hidden" name="loanId" value="${param.loanId}" />
                <button type="submit" class="btn btn-success">Ya, Kembalikan</button>
                <a href="${pageContext.request.contextPath}/admin/adminLoanHistory" class="btn btn-secondary">Batal</a>
            </form>
        </div>
    </div>
</div>

</body>
</html>
