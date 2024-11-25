package com.example.characterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val warriorRadioButton = findViewById<RadioButton>(R.id.warriorRadioButton)
        val wizardRadioButton = findViewById<RadioButton>(R.id.wizardRadioButton)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val button = findViewById<Button>(R.id.button)

        // warriorRadioButton을 기본 선택 상태로 설정
        warriorRadioButton.isChecked = true

        // 라디오 그룹에서 선택된 값에 따라 이미지 변경
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.warriorRadioButton -> {
                    imageView.setImageResource(R.drawable.warrior) // 전사 이미지로 변경
                }
                R.id.wizardRadioButton -> {
                    imageView.setImageResource(R.drawable.wizard) // 마법사 이미지로 변경
                }
            }
        }

        // 버튼 클릭 시 동작
        button.setOnClickListener {
            if (checkBox.isChecked) {
                showBasicDialog()
            } else {
                Toast.makeText(this, "약관에 동의해주세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 기본 다이얼로그 표시 함수
    private fun showBasicDialog() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("캐릭터 생성 완료")

        // 확인 버튼 추가
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // 다이얼로그 닫기
        }

        // 다이얼로그 생성 및 표시
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}