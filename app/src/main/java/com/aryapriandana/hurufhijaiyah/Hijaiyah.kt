package com.aryapriandana.hurufhijaiyah

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hijaiyah(
    val nama: String,
    val deskripsi: String,
    val posisi: String,
    val bentuk: String,
    val gambar: Int,
) : Parcelable
