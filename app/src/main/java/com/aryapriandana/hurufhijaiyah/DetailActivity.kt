package com.aryapriandana.hurufhijaiyah

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {

    companion object {
        const val HURUF_HIJAIYAH = "huruf_hijaiyah"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_huruf_hijaiyah)

        val gambarHuruf: ImageView = findViewById(R.id.iv_gambar_huruf)
        val namaHuruf: TextView = findViewById(R.id.tv_detail_nama_huruf)
        val posisiHuruf: TextView = findViewById(R.id.tv_detail_posisi_huruf)
        val bentukHuruf: TextView = findViewById(R.id.tv_detail_bentuk_huruf)
        val deskHuruf: TextView = findViewById(R.id.tv_detail_desk_huruf)


        val hurufHijaiyah = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hijaiyah>(HURUF_HIJAIYAH, Hijaiyah::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hijaiyah>(HURUF_HIJAIYAH)
        }

        if(hurufHijaiyah != null) {
            gambarHuruf.setImageResource(hurufHijaiyah.gambar)
            namaHuruf.text = hurufHijaiyah.nama
            bentukHuruf.text = hurufHijaiyah.bentuk
            posisiHuruf.text = hurufHijaiyah.posisi
            deskHuruf.text = hurufHijaiyah.deskripsi
        }
    }

}