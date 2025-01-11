package com.example.pamfirebase.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pamfirebase.MahasiswaApp

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(mahasiswaApplication().containerApp.repositoryMhs)
        }

        initializer {
            InsertViewModel (
                mahasiswaApplication().containerApp.repositoryMhs
            )
        }
    }
}

fun CreationExtras.mahasiswaApplication() : MahasiswaApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApp)