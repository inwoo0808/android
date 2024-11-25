package com.example.datingapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.datingapp.R
import com.google.firebase.auth.FirebaseAuth

class IntroActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ImageAdapter
    private val images = listOf(
        R.drawable.idol3, // 첫 번째 이미지
        R.drawable.idol4  // 두 번째 이미지
    )
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0

    private val runnable = object : Runnable {
        override fun run() {
            currentPage = (currentPage + 1) % images.size // 다음 페이지로 이동
            viewPager.setCurrentItem(currentPage, true) // 페이지 전환
            handler.postDelayed(this, 3000) // 3초 후에 다시 실행
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        if (currentUser != null) {
            // 사용자가 로그인된 상태
            Log.d("IntroActivity", currentUser.toString())

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 회원가입 버튼
        val buttonSignUP = findViewById<TextView>(R.id.buttonSignUP)
        buttonSignUP.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // 로그인 버튼
        val buttonLogin = findViewById<TextView>(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // 이미지 뷰페이저
        viewPager = findViewById(R.id.viewPager)
        adapter = ImageAdapter(images)
        viewPager.adapter = adapter

        // 터치로 페이징 막기
//        viewPager.isUserInputEnabled = false

        // 3초 후에 자동 페이징 시작
        handler.postDelayed({
            handler.post(runnable) // 딜레이 후 runnable 실행
        }, 3000) // 3000ms (3초) 딜레이
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable) // 액티비티 종료 시 핸들러 제거
    }
}

class ImageAdapter(private val images: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_intro_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageView.setImageResource(images[position]) // 이미지 설정
    }

    override fun getItemCount(): Int = images.size
}