package com.example.pamfirebase.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pamfirebase.model.Mahasiswa
import com.example.pamfirebase.repository.RepositoryMhs

class InsertViewModel (
    private val repoMhs: RepositoryMhs
) : ViewModel() {

}

// data class Variable yang menyimpan data input form
data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val jenisKelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = ""
)

// Menyimpan input form ke dalam entity
fun MahasiswaEvent.toMhsModel () : Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    jenisKelamin = jenisKelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan
)