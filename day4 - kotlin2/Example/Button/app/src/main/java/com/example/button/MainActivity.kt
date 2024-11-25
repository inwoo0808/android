package com.example.button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnTouchListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 버튼 초기화
        val button = findViewById<Button>(R.id.button)
        // 클릭 및 터치 이벤트 리스너 설정
        button.setOnClickListener(this)
        button.setOnTouchListener(this)
    }

    // View.OnClickListener의 onClick() 메서드 구현
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                // 버튼이 클릭되었을 때 처리할 작업
                println("Button clicked!")
            }
        }
    }

    // View.OnTouchListener의 onTouch() 메서드 구현
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                // 터치가 시작될 때 처리할 작업
                println("Button touched - ACTION_DOWN")
            }
            MotionEvent.ACTION_UP -> {
                // 터치가 끝날 때 처리할 작업
                println("Button touched - ACTION_UP")
            }
        }
        // 터치 이벤트 처리를 계속 진행할지 여부를 반환
        return true
    }
}