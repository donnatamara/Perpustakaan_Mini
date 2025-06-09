<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Logout</title>
    <!-- Bootstrap 5 CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">

    <div class="card shadow p-4" style="min-width: 320px;">
        <h3 class="mb-3 text-center">Konfirmasi Logout</h3>
        <p class="text-center mb-4">Apakah Anda yakin ingin logout?</p>
        <form action="<%=request.getContextPath()%>/LogoutServlet" method="get" class="d-flex justify-content-center gap-3">
            <button type="submit" class="btn btn-danger">Logout</button>
            <a href="<%=request.getContextPath()%>/login.jsp" class="btn btn-secondary">Batal</a>
        </form>
    </div>

    <!-- Bootstrap 5 JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
