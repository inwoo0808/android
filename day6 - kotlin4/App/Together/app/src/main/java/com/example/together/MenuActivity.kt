package com.example.together

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    private lateinit var textViewTotalQuantity: TextView
    private lateinit var textViewTotalPrice: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // 전달된 enum 값을 수신
        val categoryName = intent.getStringExtra("category") ?: Category.Burger.name // 기본값 설정
        val category = Category.valueOf(categoryName)

        // 카테고리 타이틀 설정
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = categoryName

        // Total
        textViewTotalQuantity = findViewById(R.id.textViewTotalQuantity)
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice)
        val buttonCart = findViewById<Button>(R.id.buttonCart)
        buttonCart.setOnClickListener{
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        // Menu
        val menuItems = MenuManager.menuItems.filter { it.category == category }
        val layoutIds = intArrayOf(R.id.layoutMenu1, R.id.layoutMenu2, R.id.layoutMenu3, R.id.layoutMenu4)
        val imageViewIds = intArrayOf(R.id.imageViewMenu1, R.id.imageViewMenu2, R.id.imageViewMenu3, R.id.imageViewMenu4)
        val textViewNameIds = intArrayOf(R.id.textViewName1, R.id.textViewName2, R.id.textViewName3, R.id.textViewName4)
        val textViewPriceIds = intArrayOf(R.id.textViewPrice1, R.id.textViewPrice2, R.id.textViewPrice3, R.id.textViewPrice4)
        for (i in menuItems.indices) {
            val layoutMenu = findViewById<LinearLayout>(layoutIds[i])
            layoutMenu.setOnClickListener {
                menuItems[i].quantity++
                textViewTotalQuantity.text = MenuManager.totalQuantity().toString()
                textViewTotalPrice.text = MenuManager.totalPrice().toString()
            }

            val imageViewMenu = findViewById<ImageView>(imageViewIds[i])
            imageViewMenu.setImageResource(menuItems[i].image)

            val textViewName = findViewById<TextView>(textViewNameIds[i])
            textViewName.text = menuItems[i].name

            val textViewPrice = findViewById<TextView>(textViewPriceIds[i])
            textViewPrice.text = "${menuItems[i].price}원"
        }
    }

    override fun onResume() {
        super.onResume()

        textViewTotalQuantity.text = MenuManager.totalQuantity().toString()
        textViewTotalPrice.text = MenuManager.totalPrice().toString()
    }
}