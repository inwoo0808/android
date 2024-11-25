package com.example.gameapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        // 버튼 클릭 시 동작
        button.setOnClickListener {
            // 현재 액티비티에서 다른 액티비티로 이동하는 코드
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}