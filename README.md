 Activity Tracker

Activity Tracker adalah aplikasi desktop berbasis Java yang memungkinkan pengguna untuk melacak aktivitas mereka sehari-hari secara terorganisir. Aplikasi ini dirancang untuk membantu pengguna dengan mudah menambahkan, menghapus, dan melihat daftar aktivitas mereka. Selain itu, aplikasi ini juga menyertakan beberapa fitur menarik seperti penyimpanan data otomatis yang memungkinkan pengguna untuk menyimpan riwayat aktivitas mereka antara sesi aplikasi.

Aplikasi ini menggunakan antarmuka pengguna grafis berbasis Swing di Java, sehingga mudah digunakan dan sangat cocok bagi mereka yang ingin melacak aktivitas sehari-hari seperti makan, olahraga, belajar, dan banyak lagi. Aktivitas yang ditambahkan akan disertai dengan waktu penambahannya.

 Fitur Utama

1. Menambahkan Aktivitas Baru
   Pengguna dapat menambahkan aktivitas baru dengan mudah. Aktivitas yang ditambahkan akan disertai dengan deskripsi dan waktu penambahannya yang otomatis tercatat.
   
2. Menghapus Aktivitas
   Pengguna dapat menghapus aktivitas yang sudah tidak diperlukan dengan memilihnya dari daftar dan mengklik tombol hapus.

3. Penyimpanan Data yang Berkelanjutan
   Aplikasi ini menggunakan file I/O untuk menyimpan semua aktivitas yang telah ditambahkan. Dengan demikian, meskipun aplikasi ditutup dan dibuka kembali, data aktivitas tetap ada dan tidak hilang. Semua data aktivitas disimpan dalam file teks (`activities.txt`), yang membuat aplikasi ini praktis digunakan untuk pelacakan jangka panjang.

4. Validasi Input Pengguna
   Untuk memastikan aplikasi berfungsi dengan benar, input yang dimasukkan oleh pengguna harus sesuai dan tidak kosong. Jika pengguna mencoba menambahkan aktivitas dengan input kosong, aplikasi akan menampilkan pesan kesalahan.

5. Antarmuka Pengguna yang Sederhana dan Intuitif
   Antarmuka aplikasi dirancang agar mudah digunakan dengan komponen-komponen seperti input teks untuk menambah aktivitas, tombol untuk menambah dan menghapus aktivitas, serta daftar aktivitas yang disusun rapi di jendela utama.

 Teknologi yang Digunakan

- Java: Bahasa pemrograman utama yang digunakan dalam pembuatan aplikasi ini. Java dipilih karena sifatnya yang platform-independent dan fleksibel.
- Swing: Library Java untuk membuat antarmuka grafis pengguna (GUI). Swing digunakan untuk membuat tampilan aplikasi yang menarik dan mudah digunakan, yang memungkinkan pengguna berinteraksi dengan aplikasi secara langsung.
- JUnit: Framework pengujian unit yang digunakan untuk memastikan bahwa logika aplikasi berjalan dengan benar. Pengujian unit sangat penting untuk memastikan bahwa penambahan dan penghapusan aktivitas dilakukan dengan benar tanpa kesalahan.
- File I/O: Menggunakan mekanisme Input/Output untuk menyimpan dan memuat data aktivitas dari file, sehingga data pengguna dapat bertahan antar sesi aplikasi.

 Cara Menjalankan Aplikasi

Untuk menjalankan aplikasi Activity Tracker, ikuti langkah-langkah berikut:

1. Clone Repository
   Pertama, clone repository ini ke komputer lokal Anda dengan menjalankan perintah berikut di terminal atau command prompt:
   ```bash
   git clone https://github.com/ErkPH/UAPproglan.git
