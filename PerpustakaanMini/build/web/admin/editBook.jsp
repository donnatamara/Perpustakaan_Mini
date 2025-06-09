<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Book" %>
<%
    Book book = (Book) request.getAttribute("book");
    if (book == null) {
        response.sendRedirect(request.getContextPath() + "/admin/adminBooks");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Buku</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body { background-color: #f0f2f5; font-family: 'Segoe UI', sans-serif; }
        .card-custom {
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
            animation: fadeIn 0.7s ease-in-out;
        }
        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(30px);}
            to {opacity: 1; transform: translateY(0);}
        }
        .form-label::after { content: " *"; color: red; }
    </style>
</head>
<body>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-7 col-lg-6">
            <div class="card card-custom">
                <div class="card-body">
                    <h3 class="mb-4 text-center">✏️ Edit Data Buku</h3>

                    <% if (request.getAttribute("success") != null) { %>
                        <div class="alert alert-success" role="alert">
                            <%= request.getAttribute("success") %>
                        </div>
                    <% } %>

                    <% if (request.getAttribute("error") != null) { %>
                        <div class="alert alert-danger" role="alert">
                            <%= request.getAttribute("error") %>
                        </div>
                    <% } %>

                    <form action="${pageContext.request.contextPath}/admin/editBook" method="post" onsubmit="return validateForm()">
                        <input type="hidden" name="id" value="<%= book.getId() %>">

                        <div class="mb-3">
                            <label for="title" class="form-label">Judul Buku</label>
                            <input type="text" class="form-control" id="title" name="title" value="<%= book.getTitle() %>" required placeholder="Masukkan judul buku" data-bs-toggle="tooltip" title="Wajib diisi">
                        </div>

                        <div class="mb-3">
                            <label for="author" class="form-label">Penulis</label>
                            <input type="text" class="form-control" id="author" name="author" value="<%= book.getAuthor() %>" required placeholder="Masukkan nama penulis" data-bs-toggle="tooltip" title="Wajib diisi">
                        </div>

                        <div class="mb-3">
                            <label for="stock" class="form-label">Stok</label>
                            <input type="number" class="form-control" id="stock" name="stock" min="0" value="<%= book.getStock() %>" required placeholder="Masukkan jumlah stok" data-bs-toggle="tooltip" title="Angka minimal 0">
                        </div>

                        <div class="d-flex justify-content-between">
                            <a href="${pageContext.request.contextPath}/admin/adminBooks" class="btn btn-outline-secondary">⬅ Kembali</a>
                            <button type="submit" class="btn btn-success">Simpan</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]');
    [...tooltipTriggerList].map(el => new bootstrap.Tooltip(el));

    function validateForm() {
        const title = document.getElementById("title").value.trim();
        const author = document.getElementById("author").value.trim();
        const stock = document.getElementById("stock").value.trim();

        if (title === "" || author === "" || stock === "") {
            alert("Harap isi semua kolom yang wajib diisi.");
            return false;
        }
        if (parseInt(stock) < 0 || isNaN(parseInt(stock))) {
            alert("Stok tidak boleh kurang dari 0 dan harus berupa angka.");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
