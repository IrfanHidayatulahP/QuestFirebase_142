package com.example.pamfirebase.repository

import com.example.pamfirebase.model.Mahasiswa
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class NetworkRepositoryMhs (
    private val firestore: FirebaseFirestore
) : RepositoryMhs {
    override fun getMhs(nim: String): Flow<Mahasiswa> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMhs(mahasiswa: Mahasiswa) {
        TODO("Not yet implemented")
    }

    override suspend fun updateMhs(mahasiswa: Mahasiswa) {
        TODO("Not yet implemented")
    }

    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        TODO("Not yet implemented")
    }

    override fun getAllMahasiswa(): Flow<List<Mahasiswa>> = callbackFlow {
        val mhsCollection = firestore.collection("Mahasiswa")
            .orderBy("nim", Query.Direction.ASCENDING)
            .addSnapshotListener {
                value, error ->
                if ( value != null) {
                    val mhsList = value.documents.mapNotNull {
                        // Convert dari document firestore ke data class
                        it.toObject(Mahasiswa::class.java)
                    }
                    // Fungsi untuk mengirim collection ke dataclass
                    trySend(mhsList)
                }
            }
        awaitClose {
            // Menutup collection dari firestore
            mhsCollection.remove()
        }
    }
}