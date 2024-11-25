package com.example.together

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val layoutBurger = findViewById<LinearLayout>(R.id.layoutBurger)
        val layoutPizza = findViewById<LinearLayout>(R.id.layoutPizza)
        val layoutBeer = findViewById<LinearLayout>(R.id.layoutBeer)
        val layoutCoffee = findViewById<LinearLayout>(R.id.layoutCoffee)

        val layouts = listOf(layoutBurger, layoutPizza, layoutBeer, layoutCoffee) // 레이아웃을 리스트로 저장
        val categories = Category.entries.toTypedArray() // 모든 enum 값을 가져옴

        layouts.forEachIndexed { index, layout ->
            layout.setOnClickListener {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("category", categories[index].name) // 해당 카테고리의 enum 값을 전달
                startActivity(intent)
            }
        }
    }
}