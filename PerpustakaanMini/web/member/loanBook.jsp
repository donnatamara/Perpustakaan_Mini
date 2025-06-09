<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pinjam Buku</title>
</head>
<body>
    <h2>Form Peminjaman Buku</h2>

    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <%
        }
    %>

    <form action="<%= request.getContextPath() %>/member/loanBook" method="post">
        <label for="bookId">ID Buku:</label><br>
        <input type="text" id="bookId" name="bookId" required><br><br>

        <input type="submit" value="Pinjam Buku">
    </form>

    <br>
    <a href="memberBooks.jsp">← Kembali ke Daftar Buku</a>
</body>
</html>
