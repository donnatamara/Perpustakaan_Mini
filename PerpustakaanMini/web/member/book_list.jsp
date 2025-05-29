<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Member, model.Book, java.util.List" %>
<%@ page session="true" %>
<%
    Member member = (Member) session.getAttribute("user");
    if (member == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

    List<Book> books = (List<Book>) request.getAttribute("books");
%>
<html>
<head>
    <title>Daftar Buku</title>
</head>
<body>
    <h2>Halo, <%= member.getName() %>. Berikut daftar buku:</h2>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID Buku</th>
            <th>Judul</th>
            <th>Penulis</th>
            <th>Stok</th>
        </tr>
        <%
            if (books != null) {
                for (Book b : books) {
        %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getStock() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">Tidak ada data buku.</td>
        </tr>
        <% } %>
    </table>

    <br>
    <a href="../LogoutServlet">Logout</a>
</body>
</html>
