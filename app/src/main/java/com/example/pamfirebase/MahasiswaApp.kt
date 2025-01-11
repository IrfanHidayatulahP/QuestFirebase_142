package com.example.pamfirebase

import android.app.Application
import com.example.pamfirebase.di.MahasiswaContainer

class MahasiswaApp : Application() {
    //Fungsinya untuk menyimpan instance ContainerApp
    lateinit var containerApp: MahasiswaContainer

    override fun onCreate() {
        super.onCreate()
        //Membuat instance ContainerApp
        containerApp = MahasiswaContainer(this)
        //instance adalah object yang dibuat dari class
    }
}