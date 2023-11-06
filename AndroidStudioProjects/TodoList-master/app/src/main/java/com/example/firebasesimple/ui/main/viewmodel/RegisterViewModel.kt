package com.example.firebasesimple.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasesimple.data.api.AuthApi
import com.example.firebasesimple.data.model.User
import com.example.firebasesimple.data.repository.AuthRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

/**회원 가입 화면과 관련된 ViewModel 클래스. 사용자의 입력을 처리하고, AuthRepository를 통해 회원 가입 로직을 실행.
 * View(Activity)와 Model(repository) 간의 중재자 역할을 수행.**/

/**
 * 1. AuthRepository를 생성자로 받고, 생성자 주입을 통해 AuthRepository의 인스턴스를 전달 받음
 * 2. registrationStatus는 회원가입 상태를 나타내는 LiveData. 회원가입 성공시 True, else -> False
 * 3. register Method는 사용자의 정보를 인자로 받아 viewModelScope에서 비동기적으로 회원가입 로직 실행
 * 4. authRepository.register 를 호출해서 회원가입 처리, 성공 시 registration 를 true로 설정**/

class RegisterViewModel(private val authRepository: AuthRepository) : ViewModel() {
    private val _registrationStatus = MutableLiveData<Boolean>()
    val registrationStatus: LiveData<Boolean>
        get() = _registrationStatus

    fun register(email: String, password: String, nickname: String, name: String) {
        viewModelScope.launch {
            try {
                val authResult = authRepository.registerUser(email, password, nickname, name).await()
                val firebaseUser = authResult.user
                val userId = firebaseUser?.uid
                if (userId != null) {
                    val user = User(userId, email, nickname, name)
                    authRepository.saveUser(user)
                    _registrationStatus.value = true
                } else {
                    _registrationStatus.value = false
                }
            } catch (e: Exception) {
                _registrationStatus.value = false
            }
        }
    }
}