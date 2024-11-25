package com.example.calculator1

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

        // 버튼들
        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val buttonInit = findViewById<Button>(R.id.button_init)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttonSubtract = findViewById<Button>(R.id.button_subtract)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonDivide = findViewById<Button>(R.id.button_divide)
        val buttonEqual = findViewById<Button>(R.id.button_equal)

        // 숫자 버튼 클릭했을 때 동작
        button0.setOnClickListener {
            setDecimalButtonClicked(0)
        }
        button1.setOnClickListener {
            setDecimalButtonClicked(1)
        }
        button2.setOnClickListener {
            setDecimalButtonClicked(2)
        }
        button3.setOnClickListener {
            setDecimalButtonClicked(3)
        }
        button4.setOnClickListener {
            setDecimalButtonClicked(4)
        }
        button5.setOnClickListener {
            setDecimalButtonClicked(5)
        }
        button6.setOnClickListener {
            setDecimalButtonClicked(6)
        }
        button7.setOnClickListener {
            setDecimalButtonClicked(7)
        }
        button8.setOnClickListener {
            setDecimalButtonClicked(8)
        }
        button9.setOnClickListener {
            setDecimalButtonClicked(9)
        }

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

            if (add) {
                textView.text = "${textView.text} = ${a!! + b!!}"
            } else if (subtract) {
                textView.text = "${textView.text} = ${a!! - b!!}"
            } else if (multiply) {
                textView.text = "${textView.text} = ${a!! * b!!}"
            } else if (divide) {
                textView.text = "${textView.text} = ${a!! / b!!}"
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