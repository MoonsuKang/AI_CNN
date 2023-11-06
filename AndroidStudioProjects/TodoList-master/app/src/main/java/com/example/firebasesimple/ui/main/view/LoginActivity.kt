package com.example.firebasesimple.ui.main.view

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.firebasesimple.R
import com.example.firebasesimple.data.api.FirebaseAuthApi
import com.example.firebasesimple.data.repository.AuthRepository
import com.example.firebasesimple.databinding.ActivityLoginBinding
import com.example.firebasesimple.utils.InputValidator
import com.google.firebase.FirebaseApp

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val authRepository = AuthRepository(FirebaseAuthApi())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.parseColor("#000000")
        // Firebase 앱 초기화
        FirebaseApp.initializeApp(this)
        // Toolbar hide
        supportActionBar?.hide()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val password = binding.inputPassword.text.toString()
            loginUser(email, password)
        }

        binding.goRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun loginUser(email: String, password: String) {
        if (InputValidator.isValidEmail(email) && InputValidator.isValidPassword(password)) {
            authRepository.loginUser(email, password)
                .addOnSuccessListener {
                    // 로그인 성공 처리
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    // 로그인 성공 후에 다음 화면으로 이동하는 등의 처리를 진행할 수 있습니다.
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener { exception ->
                    // 로그인 실패 처리
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "Failed to login: ${exception.message}")
                }
        } else {
            // 유효성 검사 실패 처리
            Toast.makeText(this, "입력이 올바르지 않습니다.", Toast.LENGTH_SHORT).show()
        }
    }

}