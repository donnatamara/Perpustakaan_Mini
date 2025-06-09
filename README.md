# **📚 Perpustakaan Mini**

Aplikasi **Perpustakaan Mini** adalah aplikasi web sederhana berbasis Java yang digunakan untuk mengelola data buku, peminjaman, dan pengguna (admin & member). Aplikasi ini bertujuan untuk membantu mahasiswa memahami konsep dasar **Pemrograman Berorientasi Objek (OOP)** di Java seperti **encapsulation**, **inheritance**, **polymorphism**, serta menerapkan arsitektur **MVC (Model-View-Controller)**. 

Aplikasi ini dikembangkan menggunakan teknologi **JSP**, **Servlet**, dan **JDBC** untuk koneksi database (MySQL). Antarmuka berbasis halaman web HTML dan JSP.

## 👥 Role Pengguna

- **Admin**: Dapat melihat daftar buku dan mengelola data buku (seperti edit buku, hapus buku, dan menambah buku).
- **Member**: Dapat melihat daftar buku yang tersedia dan riwayat peminjaman.

## 🛠️Fitur
- **Fitur Umum**
  Login & Logout: Sistem otentikasi berbasis peran (Admin & Member) dengan manajemen sesi.
  
- **Fitur Admin**
  - Manajemen Buku (CRUD): Admin dapat menambah, melihat, mengubah, dan menghapus data buku.
  - Manajemen Peminjaman: Admin dapat melihat seluruh riwayat peminjaman dan memproses pengembalian buku.
    
- **Fitur Member**
  - Katalog & Peminjaman: Member dapat melihat katalog buku dan melakukan peminjaman.
  - Riwayat Peminjaman: Member dapat melihat riwayat peminjaman buku mereka.

## 🧱 Struktur Kelas (Class Diagram)

Beberapa class utama dalam aplikasi ini:
- `User` (abstract): Kelas dasar untuk `Admin` dan `Member`, memiliki atribut `id`, `name`, `password`, `role`, serta method `login()`.
- `Admin`: Turunan dari `User`, menyimpan data user seperti `id`, `name` dan `password` serta memiliki method `tampilkanInfo()` dan `logout()`.
- `Member`: Turunan dari `User`, menyimpan data user seperti `id`, `name` dan `password` serta memiliki method `tampilkanInfo()` dan `logout()`.
- `Books`: Menyimpan data buku seperti `id`, `title`, `author`, dan `stock`. Untuk menu Admin memiliki method `addBook()`, `updateBook()`, dan `deleteBook()`. Untuk menu Member memiliki method `loanBook()`.
- `LoanHistory`: Mencatat informasi peminjaman (`id`, `nama`, `tanggalPeminjaman`, `tanggalKembali`, dan `status`).

### 📊 Class Diagram
![Class Diagram Tubes PBO (1) drawio](https://github.com/user-attachments/assets/f3af258b-a0aa-4e37-8414-9fe1cf8fac83)

## 🖼 Screenshot Tampilan Aplikasi

Berikut adalah tampilan antarmuka aplikasi:

![image](https://github.com/user-attachments/assets/3fd752b0-7b00-41c3-954b-16653b77ed21)


**Admin**
![image](https://github.com/user-attachments/assets/53340690-dbad-4341-b17d-9a37d45ec7d6)
![image](https://github.com/user-attachments/assets/012fa7e0-7066-414d-82b0-16b698f1762b)
![image](https://github.com/user-attachments/assets/5068574a-aed8-4780-8280-ae80ad851bdf)
![image](https://github.com/user-attachments/assets/67db0e5e-e25e-44cf-8cb9-0d46e3ebb6e8)


**Member**
![image](https://github.com/user-attachments/assets/67e14c6f-460a-41ac-9c75-bcfbbb26f523)
![image](https://github.com/user-attachments/assets/26042e75-b605-4707-b817-6921fbb9df70)
![image](https://github.com/user-attachments/assets/00cda337-7450-40fa-870d-e05f41355c62)



## 🔗 Kolaborator
- @shafasyahii
- @donnatamara
- @Briizzz
