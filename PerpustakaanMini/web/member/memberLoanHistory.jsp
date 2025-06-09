<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Loan" %>
<%@ page import="java.util.List" %>
<%@ page session="true" %>
<%
    List<Loan> loans = (List<Loan>) request.getAttribute("loans");
%>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Riwayat Peminjaman Buku</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4 text-center">📚 Riwayat Peminjaman Buku</h2>

    <div class="table-responsive">
        <table class="table table-bordered table-hover table-striped align-middle">
            <thead class="table-dark text-center">
                <tr>
                    <th>ID</th>
                    <th>Nama</th>
                    <th>Judul Buku</th>
                    <th>Tanggal Pinjam</th>
                    <th>Tanggal Kembali</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <%
                if (loans != null && !loans.isEmpty()) {
                    for (Loan loan : loans) {
            %>
                <tr>
                    <td><%= loan.getId() %></td>
                    <td><%= loan.getNama() %></td>
                    <td><%= loan.getJudulBuku() %></td>
                    <td><%= loan.getTanggalPeminjaman() %></td>
                    <td><%= loan.getTanggalKembali() != null ? loan.getTanggalKembali() : "Belum dikembalikan" %></td>
                    <td>
                        <span class="badge <%= "Dipinjam".equalsIgnoreCase(loan.getStatus()) ? "bg-warning text-dark" : "bg-success" %>">
                            <%= loan.getStatus() %>
                        </span>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="6" class="text-center text-muted">Belum ada data peminjaman.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
