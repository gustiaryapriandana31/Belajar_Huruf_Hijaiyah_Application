package com.aryapriandana.hurufhijaiyah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){

    private lateinit var rvHuruf: RecyclerView
    private val list = ArrayList<Hijaiyah>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHuruf = findViewById(R.id.rv_hijaiyah)
        rvHuruf.setHasFixedSize(true)

        list.addAll(getListHuruf())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_about_info -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun getListHuruf(): ArrayList<Hijaiyah> {
        val dataNama = resources.getStringArray(R.array.nama_huruf)
        val dataBentuk = resources.getStringArray(R.array.bentuk_huruf)
        val dataPosisi = resources.getStringArray(R.array.posisi_huruf)
        val dataDeskripsi = resources.getStringArray(R.array.deskripsi_huruf)
        val dataGambar = resources.obtainTypedArray(R.array.gambar_huruf)
        val listHijaiyah = ArrayList<Hijaiyah>()

        for(counter in dataNama.indices) {
            val hijaiyah = Hijaiyah(dataNama[counter], dataDeskripsi[counter],
                            dataPosisi[counter], dataBentuk[counter], dataGambar.getResourceId(counter, -1),)
            listHijaiyah.add(hijaiyah)
        }

        return listHijaiyah
    }

    private fun showRecyclerList() {
        rvHuruf.layoutManager = LinearLayoutManager(this)
        var hurufHijaiyahAdapter = HurufHijaiyahAdapter(list)
        rvHuruf.adapter =hurufHijaiyahAdapter
    }
}