# **📚 Perpustakaan Mini**

Aplikasi "Perpustakaan Mini" adalah aplikasi sederhana berbasis Java yang digunakan untuk mengelola data buku, peminjaman, dan pengguna (admin & member). Aplikasi ini bertujuan untuk membantu mahasiswa memahami konsep dasar pemrograman berorientasi objek (OOP) di Java seperti encapsulation, inheritance, polymorphism, abstract class, interface, exception handling, serta menerapkan konsep MVC (Model-View-Controller). Aplikasi ini menggunakan antarmuka grafis sederhana berbasis Java Swing dan menyimpan data dalam database SQLite.

## 👥 Role Pengguna
- *Admin*: Dapat menambahkan dan menghapus buku dari perpustakaan.
- *Member*: Dapat meminjam dan mengembalikan buku.

## 🧱 Struktur Kelas (Class Diagram)

Terdapat beberapa class utama:
- User: Kelas dasar untuk Admin dan Member, memiliki atribut id, name, username, password, dan method login().
- Admin: Turunan dari User, dapat melakukan addBook() dan delBook().
- Member: Turunan dari User, dapat melakukan borrowBook() dan returnBook().
- Book: Menyimpan data buku (id, title, author).
- Loan: Menyimpan informasi peminjaman (loanId, userId, bookId).
- SessionManager: Menyimpan user yang sedang login, dan menangani getUser() serta logout().

### 📊 Class Diagram
![Class Diagram](docs/class_diagram.png)

## 🖼 Screenshot Tampilan Aplikasi

Berikut adalah tampilan antarmuka aplikasi:

![image](https://github.com/user-attachments/assets/1e511783-58b4-44be-9f76-1bf5a5166e8a)

![Tampilan Peminjaman Buku](screenshots/borrowbook.png)

>Catatan: Tampilan dapat berubah seiring perkembangan project.

## 🔗 Kolaborator
- @shafasyahii
- @donnatamara
- @Briizzz
