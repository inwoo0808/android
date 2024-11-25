package com.example.calulator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // 계산 창
    private lateinit var textView: TextView

    // 연산을 할 두 개의 변수
    var a: Int? = null
    var b: Int? = null

    // 사칙연산 버튼이 눌렸는지 판단
    var arithmetic = false

    // 어떤 사칙연산으로 수행 중인지
    var add = false
    var subtract = false
    var multiply = false
    var divide = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 계산 창
        textView = findViewById(R.id.textView)

        // 숫자 버튼 레이아웃 ID를 배열로 저장
        val numberButtons = arrayOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9
        )

        // 0부터 9까지 반복하며 버튼 초기화
        for (i in 0..9) {
            val button = findViewById<Button>(numberButtons[i])
            button.setOnClickListener {
                // 숫자 버튼 클릭했을 때 동작
                setDecimalButtonClicked(i)
            }
        }

        val buttonInit = findViewById<Button>(R.id.button_init)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttonSubtract = findViewById<Button>(R.id.button_subtract)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonDivide = findViewById<Button>(R.id.button_divide)
        val buttonEqual = findViewById<Button>(R.id.button_equal)

        buttonInit.setOnClickListener {
            arithmetic = false
            add = false
            subtract = false
            multiply = false
            divide = false
            a = null
            b = null
            textView.text = ""
        }

        buttonAdd.setOnClickListener {
            arithmetic = true
            add = true
            textView.text = "${textView.text} +"
        }

        buttonSubtract.setOnClickListener {
            arithmetic = true
            subtract = true
            textView.text = "${textView.text} -"
        }

        buttonMultiply.setOnClickListener {
            arithmetic = true
            multiply = true
            textView.text = "${textView.text} *"
        }

        buttonDivide.setOnClickListener {
            arithmetic = true
            divide = true
            textView.text = "${textView.text} /"
        }

        buttonEqual.setOnClickListener {
            // a 또는 b가 빈 값일 때는 아래 코드를 수행하지 않는다.
            if (a == null && b == null) return@setOnClickListener

            textView.text = when {
                add -> "${textView.text} = ${a!! + b!!}"
                subtract -> "${textView.text} = ${a!! - b!!}"
                multiply -> "${textView.text} = ${a!! * b!!}"
                divide -> "${textView.text} = ${a!! / b!!}"
                else -> textView.text // 어떤 조건도 만족하지 않을 경우 기존 텍스트 유지
            }

            // 연산 마친 후 초기화
            arithmetic = false
            add = false
            subtract = false
            multiply = false
            divide = false
            a = null
            b = null
        }
    }

    fun setDecimalButtonClicked(i: Int) {
        if (!arithmetic) {
            if (a == null) {
                a = i
            } else if (a.toString().length < 4) {
                a = "${a}$i".toInt()
            }
            textView.text = a.toString()
        } else {
            if (b == null) {
                b = i
                textView.text = "${textView.text} $b"
            } else if (b.toString().length < 4) {
                b = "${b}$i".toInt()
                textView.text = "${textView.text}$i"
            }
        }
    }
}