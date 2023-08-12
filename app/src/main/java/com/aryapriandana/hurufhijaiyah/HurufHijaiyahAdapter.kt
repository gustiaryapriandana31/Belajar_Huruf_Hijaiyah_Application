package com.aryapriandana.hurufhijaiyah

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HurufHijaiyahAdapter(private val listHuruf: ArrayList<Hijaiyah>) : RecyclerView.Adapter<HurufHijaiyahAdapter.HijaiyahViewHolder>() {
    class HijaiyahViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val gambarHuruf: ImageView = itemView.findViewById(R.id.img_huruf_hijaiyah)
        private val namaHuruf: TextView = itemView.findViewById(R.id.tv_nama_huruf)
        private val deskHuruf: TextView = itemView.findViewById(R.id.tv_desk_huruf)

        fun binding(huruf: Hijaiyah) {
            namaHuruf.text = huruf.nama
            deskHuruf.text = huruf.deskripsi
            gambarHuruf.setImageResource(huruf.gambar)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.HURUF_HIJAIYAH, huruf)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HurufHijaiyahAdapter.HijaiyahViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_huruf_hijaiyah, parent, false)
        return HijaiyahViewHolder(view)
    }

    override fun onBindViewHolder(holder: HurufHijaiyahAdapter.HijaiyahViewHolder, position: Int) {
        holder.binding(listHuruf[position])
    }

    override fun getItemCount(): Int = listHuruf.size


}