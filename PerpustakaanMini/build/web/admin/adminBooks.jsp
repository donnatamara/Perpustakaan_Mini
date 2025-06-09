<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<%
    model.Admin admin = (model.Admin) session.getAttribute("user");
    boolean isAdmin = (admin != null);
    String status = request.getParameter("status");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kelola Buku</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>📚 Kelola Buku</h2>
        <a href="addBook.jsp" class="btn btn-success">+ Tambah Buku</a>
    </div>

    <% if (status != null) { %>
        <div class="alert 
            <% if ("deleted".equals(status) || "updated".equals(status)) { %>alert-success<% 
               } else if ("notfound".equals(status) || "error".equals(status) || "invalid".equals(status)) { %>alert-danger<% } %>">
            <% if ("deleted".equals(status)) { %>
                Buku berhasil dihapus.
            <% } else if ("updated".equals(status)) { %>
                ✅ Perubahan data berhasil disimpan.
            <% } else if ("notfound".equals(status)) { %>
                Buku tidak ditemukan.
            <% } else if ("error".equals(status)) { %>
                Terjadi kesalahan saat menghapus buku.
            <% } else if ("invalid".equals(status)) { %>
                ID buku tidak valid.
            <% } %>
        </div>
    <% } %>

    <div class="card shadow-sm">
        <div class="card-body">
            <table class="table table-bordered table-hover align-middle bg-white">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Judul</th>
                        <th>Penulis</th>
                        <th>Stok</th>
                        <th>Aksi</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>${book.id}</td>
                            <td>${book.title}</td>
                            <td>${book.author}</td>
                            <td>${book.stock}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/editBook?id=${book.id}" class="btn btn-primary btn-sm me-1">Edit</a>
                                <a href="${pageContext.request.contextPath}/admin/deleteBook?id=${book.id}" 
                                   onclick="return confirm('Yakin ingin menghapus buku ini?');" 
                                   class="btn btn-danger btn-sm">Hapus</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty books}">
                        <tr>
                            <td colspan="5" class="text-center text-muted">Belum ada buku ditambahkan.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
