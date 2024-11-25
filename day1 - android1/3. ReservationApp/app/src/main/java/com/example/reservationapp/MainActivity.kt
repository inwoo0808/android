package com.example.reservationapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var spinner: Spinner
    private lateinit var buttonDate: Button
    private lateinit var button: Button

    private var name = ""
    private var location = ""
    private var date = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View 초기화
        editText = findViewById(R.id.editText)
        spinner = findViewById(R.id.spinner)
        buttonDate = findViewById(R.id.button_date)
        button = findViewById(R.id.button)

        // 드롭다운에 사용할 데이터 목록
        val items = listOf("서울", "양양", "대전", "광주", "부산")

        // 어댑터 설정
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // 선택 이벤트 처리
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                location = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // 아무 것도 선택되지 않았을 때의 처리
            }
        }

        // 날짜 버튼 클릭 시 동작
        buttonDate.setOnClickListener {
            showDatePickerDialog()
        }

        // 예약 버튼 클릭 시 동작
        button.setOnClickListener {
            name = editText.text.toString()

            if (name.isNotEmpty()) {
                showBasicDialog()
                // 입력 필드 초기화
                editText.text.clear()
            }
        }
    }

    // 기본 다이얼로그 표시 함수
    private fun showBasicDialog() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("예약이 완료되었습니다.")
        builder.setMessage("이름 : $name\n지점 : $location\n예약일 : $date")

        // 확인 버튼 추가
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // 다이얼로그 닫기
        }

        // 다이얼로그 생성 및 표시
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // DatePickerDialog 생성
        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            // 선택한 날짜를 텍스트뷰에 표시
            date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            buttonDate.text = date
        }, year, month, day)

        // 다이얼로그 표시
        datePickerDialog.show()
    }
}