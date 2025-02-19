# ActivityTracker

**ActivityTracker** adalah aplikasi berbasis Java yang memungkinkan pengguna untuk melacak aktivitas mereka. Aplikasi ini menyediakan fungsi untuk menambah, memperbarui, menghapus, dan menyimpan data aktivitas beserta timestamp (tanggal dan waktu) untuk setiap aktivitas.

## Fitur

- **Tambah Aktivitas**: Pengguna dapat menambahkan aktivitas baru yang mencakup ID, nama aktivitas, deskripsi, dan timestamp (tanggal dan waktu saat itu).
- **Perbarui Aktivitas**: Pengguna dapat memperbarui detail aktivitas yang ada, termasuk memperbarui nama, deskripsi, dan timestamp.
- **Hapus Aktivitas**: Pengguna dapat menghapus aktivitas dari daftar.
- **Simpan Data**: Pengguna dapat menyimpan daftar aktivitas yang ada ke dalam file, sehingga data tetap ada meskipun aplikasi ditutup.
- **Muat Data**: Saat aplikasi dijalankan, data yang telah disimpan akan dimuat secara otomatis dari file jika ada.

## Persyaratan

- Java Development Kit (JDK) 8 atau lebih tinggi
- Editor teks atau IDE (misalnya IntelliJ IDEA) untuk menjalankan aplikasi

## Instalasi

1. Clone repositori atau unduh file sumber.
2. Pastikan Java 8 atau versi lebih tinggi terinstal di sistem Anda.
3. Buka proyek ini di IDE pilihan Anda atau jalankan dari command line.

## Cara Menggunakan

1. **Menjalankan Aplikasi**:
   - Jalankan file `Main.java` untuk meluncurkan aplikasi dan menampilkan antarmuka pelacakan aktivitas.

2. **Menambahkan Aktivitas**:
   - Klik tombol "Add" untuk membuka dialog.
   - Masukkan ID, nama, dan deskripsi aktivitas.
   - Timestamp (tanggal dan waktu saat itu) akan ditambahkan secara otomatis saat aktivitas ditambahkan.
   - Klik "OK" untuk menambahkan aktivitas ke tabel.

3. **Memperbarui Aktivitas**:
   - Pilih baris aktivitas dalam tabel.
   - Klik tombol "Update" untuk mengubah ID, nama, deskripsi, dan timestamp.
   - Klik "OK" untuk menyimpan perubahan.

4. **Menghapus Aktivitas**:
   - Pilih baris aktivitas dalam tabel.
   - Klik tombol "Delete" untuk menghapus aktivitas yang dipilih.

5. **Menyimpan Aktivitas**:
   - Klik tombol "Save" untuk menyimpan daftar aktivitas saat ini ke dalam file (`activities.txt`).
   - File tersebut akan menyimpan data aktivitas dalam format: `ID, Nama Aktivitas, Deskripsi, Timestamp`.

6. **Memuat Aktivitas**:
   - Saat aplikasi dijalankan, aplikasi akan mencoba memuat aktivitas yang disimpan dari `activities.txt`. Jika file tersebut ada, data akan dimuat dan ditampilkan di tabel.

## Struktur File

- **Main.java**: Titik masuk aplikasi. Menginisialisasi kelas `ActivityTrackerApp`.
- **ActivityTrackerApp.java**: Berisi antarmuka pengguna utama untuk aplikasi, termasuk tabel dan modelnya.
- **GUIHandler.java**: Mengelola interaksi antarmuka pengguna (tombol dan tabel).
- **CRUDHandler.java**: Menangani operasi Create, Read, Update, dan Delete (CRUD) untuk data aktivitas.
- **activities.txt**: File teks tempat data aktivitas disimpan dan dimuat (disimpan dalam format CSV).

## Teknologi yang Digunakan

- **Java**: Bahasa pemrograman yang digunakan untuk mengembangkan aplikasi ini.
- **Swing**: Toolkit GUI yang digunakan untuk membangun antarmuka grafis aplikasi.

## Contoh Format Data di `activities.txt`
1, Morning Jog, A 30-minute jog in the park, 2024-12-27 10:00:00 2, Reading, Reading a new programming book, 2024-12-27 10:30:00 3, Lunch, Eating lunch at the cafeteria, 2024-12-27 12:00:00

