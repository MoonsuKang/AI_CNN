package com.example.firebasesimple.utils

import android.util.Patterns

/** 사용자의 입력 유효성을 검사하는 유틸리티 클래스. 이메일 형식, 비밀번호 조건 등을 확인하는 기능을 구현.
 * 유효성 검사는 Client 측에서 하는 것이 좋음. **/

object InputValidator {
    fun isValidEmail(email: String): Boolean {
        val emailPattern = Patterns.EMAIL_ADDRESS
        return emailPattern.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        // 여기에 비밀번호 유효성 검사 로직을 추가.
        // 예: 비밀번호는 특정 조건을 충족해야 함 (최소 길이, 대문자/소문자/숫자 등)
        return password.length >= 6
    }

    fun isValidNickname(nickname: String): Boolean {
        // 여기에 닉네임 유효성 검사 로직을 추가.
        // 예: 닉네임은 특정 조건을 충족해야 함 (최소 길이, 특수문자 제한 등)
        return nickname.isNotEmpty()
    }

    fun isValidName(name: String): Boolean {
        // 여기에 이름 유효성 검사 로직을 추가.
        // 예: 이름은 특정 조건을 충족해야 함 (최소 길이, 특수문자 제한 등)
        return name.isNotEmpty()
    }
}
