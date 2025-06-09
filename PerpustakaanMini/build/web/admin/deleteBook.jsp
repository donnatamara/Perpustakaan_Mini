<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>
<%@ page import="dao.BookDAO" %>
<%
    String status = request.getParameter("status");
    String message = "";

    if ("deleted".equals(status)) {
        message = "Book has been successfully deleted.";
    } else if ("notfound".equals(status)) {
        message = "Book not found.";
    } else if ("invalid".equals(status)) {
        message = "Invalid book ID.";
    } else if ("error".equals(status)) {
        message = "An error occurred while deleting the book.";
    }

    List<Book> bookList = BookDAO.getAllBooks();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Book Management</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin-top: 20px;
        }
        th, td {
            padding: 8px 12px;
            border: 1px solid #ccc;
        }
        .message {
            margin-top: 10px;
            color: <%= "deleted".equals(status) ? "green" : "red" %>;
        }
    </style>
</head>
<body>
    <h1>Book Management</h1>

    <% if (!message.isEmpty()) { %>
        <p class="message"><%= message %></p>
    <% } %>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Stock</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <% for (Book book : bookList) { %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getStock() %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/admin/deleteBook.jsp?id=<%= book.getId() %>"
                       onclick="return confirm('Are you sure you want to delete this book?');">
                        Delete
                    </a>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
</body>
</html>
