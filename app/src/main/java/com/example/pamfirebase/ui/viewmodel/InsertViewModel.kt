package com.example.pamfirebase.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pamfirebase.model.Mahasiswa
import com.example.pamfirebase.repository.RepositoryMhs

class InsertViewModel (
    private val repoMhs: RepositoryMhs
) : ViewModel() {

}

sealed class FormState {
    object Idle : FormState()
    object Loading : FormState()
    data class Succes(val message: String) : FormState()
    data class Error(val message: String) : FormState()
}

data class FormErrorState (
    val nim: String? = null,
    val nama: String? = null,
    val jenisKelamin: String? = null,
    val alamat: String? = null,
    val kelas: String? = null,
    val angkatan: String? = null
) {
    fun isValid() : Boolean {
        return nim == null && nama == null && jenisKelamin == null &&
                alamat == null && kelas == null && angkatan == null
    }
}

data class InsertUiState (
    val insertUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
)

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