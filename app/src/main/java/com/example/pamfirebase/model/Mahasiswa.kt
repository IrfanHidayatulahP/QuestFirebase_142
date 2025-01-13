package com.example.pamfirebase.model

data class Mahasiswa(
    val nim: String,
    val nama: String,
    val alamat: String,
    val gender: String,
    val kelas: String,
    val angkatan: String,
    val judulSkripsi: String,
    val pembimbing: String
) {
    constructor() :this("", "", "", "", "","",
        "", "")
}