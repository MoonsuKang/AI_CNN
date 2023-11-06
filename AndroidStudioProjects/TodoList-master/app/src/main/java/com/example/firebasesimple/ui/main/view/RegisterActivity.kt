package com.example.firebasesimple.ui.main.view

import android.content.ContentValues.TAG
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.example.firebasesimple.R
import com.example.firebasesimple.data.api.AuthApi
import com.example.firebasesimple.data.api.FirebaseAuthApi
import com.example.firebasesimple.data.repository.AuthRepository
import com.example.firebasesimple.databinding.ActivityRegisterBinding
import com.example.firebasesimple.ui.main.viewmodel.RegisterViewModel
import com.example.firebasesimple.utils.InputValidator
import com.google.firebase.FirebaseApp

/** 사용자의 이메일, 비밀번호 등을 입력받고, 회원 가입 버튼과 관련된 이벤트 처리 로직을 구현**/
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val authRepository = AuthRepository(FirebaseAuthApi())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.parseColor("#000000")
        supportActionBar?.hide()
        // Firebase 앱 초기화
//        FirebaseApp.initializeApp(this)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val nickname = binding.editNickname.text.toString()
            val name = binding.editName.text.toString()
            registerUser(email, password, nickname, name)
        }

        // 뒤로 가기 버튼 클릭 이벤트
        findViewById<ImageButton>(R.id.back_btn).setOnClickListener {
            finish()
        }
    }

    private fun registerUser(email: String, password: String, nickname: String, name: String) {
        if (InputValidator.isValidEmail(email) &&
            InputValidator.isValidPassword(password) &&
            InputValidator.isValidNickname(nickname) &&
            InputValidator.isValidName(name)
        ) {
            authRepository.registerUser(email, password, nickname, name)
                .addOnSuccessListener {
                    // 회원 가입 성공 처리
                    Toast.makeText(this, "회원 가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                    // 회원 가입이 완료된 후에 다음 화면으로 이동하는 등의 처리를 진행할 수 있습니다.
                }
                .addOnFailureListener { exception ->
                    // 회원 가입 실패 처리
                    Toast.makeText(this, "회원 가입에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "Failed to register user: ${exception.message}")
                }
        } else {
            // 유효성 검사 실패 처리
            Toast.makeText(this, "입력이 올바르지 않습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}
