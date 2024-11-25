package com.example.matchingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View 초기화
        editText = findViewById(R.id.editText)
        editText2 = findViewById(R.id.editText2)
        button = findViewById(R.id.button)

        // 버튼 클릭 시 동작
        button.setOnClickListener {
            val inputText = editText.text.toString()
            val inputText2 = editText2.text.toString()

            if (inputText.isNotEmpty() && inputText2.isNotEmpty()) {
                showBasicDialog()
            } else {
                Toast.makeText(this, "이름을 입력해주세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 기본 다이얼로그 표시 함수
    private fun showBasicDialog() {
        val builder = AlertDialog.Builder(this)

        val randomNumber = Random.nextInt(0, 101)

        builder.setTitle("커플 매칭 확률")
        builder.setMessage("$randomNumber% 입니다.")

        // 확인 버튼 추가
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // 다이얼로그 닫기
        }

        // 다이얼로그 생성 및 표시
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}