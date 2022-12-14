package com.infnet.devandroidat.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.infnet.devandroidat.models.*


const val TAG = "PadariasFirebase"

class PadariasRepository private constructor() {


// ...
// Initialize Firebase Auth

    companion object {

        lateinit var auth: FirebaseAuth

//        lateinit var db: FirebaseFirestore
//
//        lateinit var colecaoPadarias: CollectionReference
//
//        lateinit var colecaoPaes: CollectionReference

        private var INSTANCE: PadariasRepository? = null
        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = PadariasRepository()
            }
            auth = Firebase.auth
            // Banco de dados Firestore
//            db = Firebase.firestore
//
//            // Coleção de padarias:
//            colecaoPadarias = db.collection("padarias")
//
//            // Coleção de paes:
//            colecaoPaes = db.collection("paes")

        }

        fun get(): PadariasRepository {
            return INSTANCE
                ?: throw IllegalStateException("PadariasRepository deve ser inicializado.")
        }
    }

    // Auth  ///////////////////////////////////////////////////////////////////////////////////////

    fun getCurrentUser() = auth.currentUser

    fun isLoggedIn(): Boolean {

        if (getCurrentUser() != null) {
            return true
        }
        return false
    }

    // Faça o mesmo que foi feito com o Login
    fun cadastrarUsuarioComSenha(
        email: String,
        password: String
    ): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }

    fun login(
        email: String,
        password: String
    ): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
    }

    fun logout() {
        auth.signOut()
    }





}