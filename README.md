# **📚 Perpustakaan Mini**

Aplikasi **Perpustakaan Mini** adalah aplikasi web sederhana berbasis Java yang digunakan untuk mengelola data buku, peminjaman, dan pengguna (admin & member). Aplikasi ini bertujuan untuk membantu mahasiswa memahami konsep dasar **Pemrograman Berorientasi Objek (OOP)** di Java seperti **encapsulation**, **inheritance**, **polymorphism**, serta menerapkan arsitektur **MVC (Model-View-Controller)**. 

Aplikasi ini dikembangkan menggunakan teknologi **JSP**, **Servlet**, dan **JDBC** untuk koneksi database (MySQL). Antarmuka berbasis halaman web HTML dan JSP.

## 👥 Role Pengguna

- **Admin**: Dapat melihat daftar buku dan mengelola data buku (di tahap lanjutan).
- **Member**: Dapat melihat daftar buku yang tersedia dan riwayat peminjaman.

## 🧱 Struktur Kelas (Class Diagram)

Beberapa class utama dalam aplikasi ini:
- `User` (abstract): Kelas dasar untuk `Admin` dan `Member`, memiliki atribut `id`, `name`, `password`, serta method `login()` dan `tampilkanInfo()`.
- `Admin`: Turunan dari `User`, memiliki implementasi `tampilkanInfo()` khusus admin.
- `Member`: Turunan dari `User`, dapat meminjam buku (terhubung ke class `Borrow`).
- `Book`: Menyimpan data buku seperti `id`, `title`, `author`, dan `stock`.
- `Borrow`: Mencatat informasi peminjaman (`memberId`, `bookId`, `borrowDate`, `returnDate`).
- DAO: Terdiri dari `UserDAO`, `BookDAO`, dan `BorrowDAO` untuk mengakses database.
- `DBUtil`: Class utilitas koneksi database.

### 📊 Class Diagram
![Class Diagram Tubes PBO](https://github.com/user-attachments/assets/727d4404-d107-4d5b-a523-aaf3328d64a1)

### Flowchart
![Image](https://github.com/user-attachments/assets/31849afb-ac02-4104-b80e-1aeb577e22fa)

## 🖼 Screenshot Tampilan Aplikasi

Berikut adalah tampilan antarmuka aplikasi:

![image](https://github.com/user-attachments/assets/9b088e15-d864-4fba-982f-f4633be00326)

![Tampilan Peminjaman Buku](screenshots/borrowbook.png)

>Catatan: Tampilan dapat berubah seiring perkembangan project.

## 🔗 Kolaborator
- @shafasyahii
- @donnatamara
- @Briizzz
