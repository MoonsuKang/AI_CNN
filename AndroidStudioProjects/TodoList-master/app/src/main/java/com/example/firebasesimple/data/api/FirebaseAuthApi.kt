package com.example.firebasesimple.data.api

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthApi : AuthApi {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun register(email: String, password: String, nickname: String, name: String): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    override fun login(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }

//    override fun logout() {
//        firebaseAuth.signOut()
//    }
}
