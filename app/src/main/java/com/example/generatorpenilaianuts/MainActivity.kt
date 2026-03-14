package com.example.generatorpenilaianuts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Kita kenalkan kotak isian dan tombolnya ke sistem
        val inputNamaDosen = findViewById<EditText>(R.id.inputNamaDosen)
        val inputMataKuliah = findViewById<EditText>(R.id.inputMataKuliah)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // 2. Kita kasih tugas ke tombol Login: "Kalau diklik, lakukan ini ya!"
        btnLogin.setOnClickListener {

            // Ambil tulisan yang diketik di layar
            val nama = inputNamaDosen.text.toString()
            val matkul = inputMataKuliah.text.toString()

            // 3. Modul 4 (Data Passing): Bikin kurir pengantar pesan pakai Intent
            val kurirIntent = Intent(this, PanelActivity::class.java)

            // Titipkan tulisan tadi ke kurirnya
            kurirIntent.putExtra("DATA_NAMA", nama)
            kurirIntent.putExtra("DATA_MATKUL", matkul)

            // Berangkat pindah halaman!
            startActivity(kurirIntent)
        }
    }
}