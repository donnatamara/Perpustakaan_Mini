<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - Mini Library</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <label>ID:</label><br>
        <input type="text" name="id" required><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>

        <label>Role:</label><br>
        <select name="role" required>
            <option value="admin">Admin</option>
            <option value="member">Member</option>
        </select><br><br>

        <input type="submit" value="Login">
    </form>

    <p style="color:red;">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </p>
</body>
</html>
