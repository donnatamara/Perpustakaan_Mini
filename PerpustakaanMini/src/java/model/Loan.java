package model;

import java.util.Date;

public class Loan {
    private String id;
    private String nama;
    private String judulBuku;
    private Date tanggalPeminjaman;
    private Date tanggalKembali;
    private String status;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getJudulBuku() { return judulBuku; }
    public void setJudulBuku(String judulBuku) { this.judulBuku = judulBuku; }

    public Date getTanggalPeminjaman() { return tanggalPeminjaman; }
    public void setTanggalPeminjaman(Date tanggalPeminjaman) { this.tanggalPeminjaman = tanggalPeminjaman; }

    public Date getTanggalKembali() { return tanggalKembali; }
    public void setTanggalKembali(Date tanggalKembali) { this.tanggalKembali = tanggalKembali; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
