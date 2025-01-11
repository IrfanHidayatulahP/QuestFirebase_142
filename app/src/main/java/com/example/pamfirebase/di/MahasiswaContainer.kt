package com.example.pamfirebase.di

import android.content.Context
import com.example.pamfirebase.repository.NetworkRepositoryMhs
import com.example.pamfirebase.repository.RepositoryMhs
import com.google.firebase.firestore.FirebaseFirestore

interface InterfaceContainerApp {
    val repositoryMhs : RepositoryMhs
}

class MahasiswaContainer (private val context: Context) : InterfaceContainerApp {
    private val firestore : FirebaseFirestore = FirebaseFirestore.getInstance()

    override val repositoryMhs: RepositoryMhs by lazy {
        NetworkRepositoryMhs(firestore)
    }
}