package com.example.generatorpenilaianuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        // 1. Kenalkan semua elemen yang ada di layar
        val tvNamaDosen = findViewById<TextView>(R.id.tvNamaDosen)
        val tvMataKuliah = findViewById<TextView>(R.id.tvMataKuliah)
        val inputJumlahMahasiswa = findViewById<EditText>(R.id.inputJumlahMahasiswa)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val tvStatusKelas = findViewById<TextView>(R.id.tvStatusKelas)
        val tvHasilGenerate = findViewById<TextView>(R.id.tvHasilGenerate)

        // ==========================================
        // MODUL 4: MENERIMA DATA PASSING (INTENT)
        // ==========================================
        // Tangkap data yang dibawa oleh kurir dari halaman Login
        val namaDosen = intent.getStringExtra("DATA_NAMA")
        val mataKuliah = intent.getStringExtra("DATA_MATKUL")

        // Pasang teksnya ke layar
        tvNamaDosen.text = "Selamat Datang, $namaDosen"
        tvMataKuliah.text = "Mata Kuliah: $mataKuliah"

        // ==========================================
        // MODUL 5: IF-ELSE & FOR LOOP
        // ==========================================
        // Berikan tugas untuk tombol Generate
        btnGenerate.setOnClickListener {
            // Ambil angka yang diketik dosen
            val inputJumlah = inputJumlahMahasiswa.text.toString()

            // Cegah error kalau dosen lupa isi angka tapi langsung klik tombol
            if (inputJumlah.isEmpty()) {
                tvStatusKelas.text = "Peringatan: Isi dulu jumlah mahasiswanya!"
                return@setOnClickListener
            }

            // Ubah teks angka menjadi tipe data angka (Integer)
            val jumlahMhs = inputJumlah.toInt()

            // --- SYARAT 1: LOGIKA IF-ELSE ---
            // Jika mahasiswa lebih dari 30 = Kelas Besar, sisanya = Kelas Reguler
            if (jumlahMhs > 30) {
                tvStatusKelas.text = "Status Kelas: Kelas Besar"
            } else {
                tvStatusKelas.text = "Status Kelas: Kelas Reguler"
            }

            // --- SYARAT 2: LOGIKA FOR LOOP ---
            // Kita siapkan kertas kosong untuk mencetak absen
            var daftarAbsen = "DAFTAR LEMBAR PENILAIAN:\n\n"

            // Mesin cetak mulai bekerja mengulang dari angka 1 sampai angka yang diinputkan
            for (i in 1..jumlahMhs) {
                daftarAbsen += "$i. Nama: ____________________ | Nilai: ____ \n\n"
            }

            // Tampilkan hasil cetakan yang panjang tadi ke layar
            tvHasilGenerate.text = daftarAbsen
        }
    }
}