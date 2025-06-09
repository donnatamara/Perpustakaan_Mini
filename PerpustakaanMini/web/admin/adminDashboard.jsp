<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Admin" %>
<%@ page session="true" %>
<%
    Admin admin = (Admin) session.getAttribute("user");
    if (admin == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h2>Selamat datang, Admin <%= admin.getName() %></h2>

    <ul>
        <li><a href="#">Kelola Buku</a></li>
        <li><a href="#">Histori Peminjaman</a></li>
        <li><a href="../LogoutServlet">Logout</a></li>
    </ul>
</body>
</html>
