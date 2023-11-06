package com.example.firebasesimple.data.api

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

/** Firebase Authentication과 상호작용하기 위한 인터페이스를 포함. 회원 가입과 관련된 API 호출 메서드 정의.**/
// AuthResult : Firebase에서 제공

/** Includes an interface for interacting with Firebase Authentication. API call method definition related to membership.**/
interface AuthApi {
    fun register(email: String, password: String, nickname: String, name: String): Task<AuthResult>
    fun login(email: String, password: String): Task<AuthResult>
//    fun logout(): Task<Void>
}