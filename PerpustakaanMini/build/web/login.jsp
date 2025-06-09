<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Login - Perpustakaan Mini</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f2f5;
        }
        .login-card {
            background-color: #fff;
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
        }
        .login-header {
            font-weight: bold;
            font-size: 1.5rem;
            color: #343a40;
        }
    </style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

<div class="card login-card p-4 w-100" style="max-width: 400px;">
    <div class="text-center mb-4">
        <div class="login-header">📚 Perpustakaan Mini</div>
        <small class="text-muted">Silakan login untuk melanjutkan</small>
    </div>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="mb-3">
            <label for="id" class="form-label">ID Pengguna</label>
            <input type="text" class="form-control" id="id" name="id" placeholder="Masukkan ID Anda" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Kata Sandi</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="••••••••" required>
        </div>

        <div class="mb-4">
            <label for="role" class="form-label">Peran</label>
            <select class="form-select" id="role" name="role" required>
                <option value="admin">Admin</option>
                <option value="member">Member</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary w-100">Login</button>
    </form>

    <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger text-center mt-3" role="alert">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
