package com.example.pamfirebase.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamfirebase.model.Mahasiswa
import com.example.pamfirebase.repository.RepositoryMhs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DetailViewModel (
    private val repoMhs: RepositoryMhs,
    private val nim: String
) : ViewModel() {

    var detailUiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
        private set


    private fun getDetailMhs() {
        viewModelScope.launch {
            detailUiState.value = DetailUiState.Loading
            try {
                val mhs = repoMhs.getMhs(nim)
                detailUiState.value = DetailUiState.Success(mhs)
            } catch (e: Exception) {
                detailUiState.value = DetailUiState.Error
            }
        }
    }

    fun deleteMhs(mahasiswa: Mahasiswa) {
        viewModelScope.launch {
            try {
                repoMhs.deleteMhs(mahasiswa)
            } catch (e: Exception) {
                println("Gagal Menghapus Mahasiswa: ${e.message}")
            }
        }
    }
}

fun Mahasiswa.toDetailUiEvent() : MahasiswaEvent {
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        gender = gender,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan,
        judulSkripsi = judulSkripsi,
        pembimbing = pembimbing
    )
}

sealed class DetailUiState {
    val detailUiEvent: MahasiswaEvent = MahasiswaEvent()
    data class Success(val mahasiswa: Flow<Mahasiswa>) : DetailUiState()
    object Error : DetailUiState()
    object Loading : DetailUiState()
}