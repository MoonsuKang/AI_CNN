package com.knu.knu_mobile_work1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.badge.BadgeUtils;

public class MainActivity extends AppCompatActivity {
    Button leftBtn, rightBtn;
    TextView rotationText;

    float currentRotation = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftBtn = findViewById(R.id.leftBtn);
        rightBtn = findViewById(R.id.rightBtn);
        rotationText = findViewById(R.id.rotationText);

        // "왼쪽" 버튼 클릭 이벤트 핸들러
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateText(-30); // 시계 반대 방향으로 30도 회전
            }
        });

        // "오른쪽" 버튼 클릭 이벤트 핸들러
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateText(30); // 시계 방향으로 30도 회전
            }
        });
    }
    private void rotateText(float degrees) {
        currentRotation = rotationText.getRotation(); // 현재 회전 각도 얻기
        currentRotation += degrees; // 요구된 각도만큼 더하기
        rotationText.setRotation(currentRotation); // 뷰 회전
    }
}