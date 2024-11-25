package com.example.gameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class ThirdActivity : AppCompatActivity() {

    private lateinit var imageButtonVS: ImageButton
    private lateinit var resultTextView: TextView

    // 가위바위보 이미지 배열
    private val rpsImages = arrayOf(R.drawable.rock, R.drawable.paper, R.drawable.scissors)
    private val rpsNames = arrayOf("바위", "보", "가위")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // 레이아웃에서 뷰를 연결
        imageButtonVS = findViewById(R.id.imageButtonVS)
        resultTextView = findViewById(R.id.textView3)

        val imageButtonRock: ImageButton = findViewById(R.id.imageButtonRock)
        val imageButtonPaper: ImageButton = findViewById(R.id.imageButtonPaper)
        val imageButtonScissors: ImageButton = findViewById(R.id.imageButtonScissors)

        // 각 버튼 클릭 시 가위바위보 대결
        imageButtonRock.setOnClickListener { playGame(0) }
        imageButtonPaper.setOnClickListener { playGame(1) }
        imageButtonScissors.setOnClickListener { playGame(2) }
    }

    private fun playGame(userChoice: Int) {
        // 컴퓨터가 랜덤으로 선택 (0: 바위, 1: 보, 2: 가위)
        val computerChoice = Random.nextInt(3)

        // imageButtonVS의 이미지를 컴퓨터가 선택한 이미지로 변경
        imageButtonVS.setImageResource(rpsImages[computerChoice])

        // 승패 판정 로직
        val result = when {
            userChoice == computerChoice -> "무승부"
            (userChoice == 0 && computerChoice == 2) || // 바위 vs 가위
                    (userChoice == 1 && computerChoice == 0) || // 보 vs 바위
                    (userChoice == 2 && computerChoice == 1) -> "사용자 승리"
            else -> "컴퓨터 승리"
        }

        showBasicDialog(result)
    }

    // 기본 다이얼로그 표시 함수
    private fun showBasicDialog(result: String) {
        val builder = AlertDialog.Builder(this)

        builder.setTitle(result)

        // 확인 버튼 추가
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // 다이얼로그 닫기
        }

        // 다이얼로그 생성
        val dialog: AlertDialog = builder.create()

        dialog.window?.setGravity(Gravity.BOTTOM) // 아래쪽으로 위치 조정

        // 다이얼로그 표시
        dialog.show()
    }
}