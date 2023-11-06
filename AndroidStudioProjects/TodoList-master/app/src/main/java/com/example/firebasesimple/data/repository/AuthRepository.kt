package com.example.firebasesimple.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.firebasesimple.data.api.AuthApi
import com.example.firebasesimple.data.model.User
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.Context

/** 회원 가입과 관련된 데이터 소스와 상호작용하는 역할을 담당하는 리포지토리 클래스. Firebase Authentication과의 통신을 관리하고, 회원 가입 로직을 처리.**/

class AuthRepository(private val authApi: AuthApi) {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users")

    fun registerUser(email: String, password: String, nickname: String, name: String): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
            .onSuccessTask { authResult ->
                val userId = authResult.user?.uid
                if (userId != null) {
                    val user = User(userId, email, nickname, name)
                    saveUser(user)
                }
                Tasks.forResult(authResult)
            }
    }

    fun loginUser(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }

    fun saveUser(user: User) {
        val userReference = databaseReference.child(user.email)

        userReference.setValue(user)
            .addOnSuccessListener {
                // 데이터 저장 성공 처리
                Log.d(TAG, "User data saved successfully")
            }
            .addOnFailureListener { exception ->
                // 데이터 저장 실패 처리
                Log.e(TAG, "Failed to save user data: ${exception.message}")
            }
    }
}