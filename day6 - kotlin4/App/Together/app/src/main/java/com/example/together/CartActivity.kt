package com.example.together

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class CartActivity : AppCompatActivity() {
    private lateinit var listViewCart: ListView
    private lateinit var adapter: CartAdapter
    private lateinit var textViewTotalPrice: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        listViewCart = findViewById(R.id.listViewCart)

        val cartItems = MenuManager.menuItems.filter { it.quantity > 0 }

        // 어댑터 초기화
        adapter = CartAdapter(this, cartItems.toMutableList()) {
            updateTotalPrice() // 콜백으로 총 가격을 업데이트하는 메서드 호출
        }
        listViewCart.adapter = adapter

        textViewTotalPrice = findViewById(R.id.textViewTotalPrice)
        // 초기 총 금액 설정
        updateTotalPrice()

        val buttonPay = findViewById<Button>(R.id.buttonPay)
        buttonPay.setOnClickListener {
            showDialog(this)
        }
    }

    // 총 가격을 업데이트하는 메서드
    private fun updateTotalPrice() {
        val totalPrice = MenuManager.totalPrice()
        textViewTotalPrice.text = totalPrice.toString()
    }

    // 다이얼로그를 표시하는 함수
    fun showDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("결제를 완료하였습니다.")

        // "확인" 버튼 클릭 시 실행할 작업
        builder.setPositiveButton("확인") { dialog, _ ->
            dialog.dismiss() // 다이얼로그 닫기

            // 장바구니 초기화
            MenuManager.reset()

            // 처음 화면으로 이동
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(intent)
            if (context is Activity) {
                context.finish() // 현재 액티비티 종료
            }
        }

        // 다이얼로그 생성 및 표시
        builder.create().show()
    }

}

class CartAdapter(
    private val context: Context,
    private val cartItems: MutableList<Menu>,
    private val onQuantityChange: () -> Unit // 콜백 함수 추가
) : BaseAdapter() {
    override fun getCount(): Int {
        return cartItems.size
    }

    override fun getItem(position: Int): Menu {
        return cartItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false)

        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewPrice = view.findViewById<TextView>(R.id.textViewPrice)
        val textViewQuantity = view.findViewById<TextView>(R.id.textViewQuantity)
        val imageViewPlus = view.findViewById<ImageView>(R.id.imageViewPlus)
        val imageViewMinus = view.findViewById<ImageView>(R.id.imageViewMinus)
        val imageViewRemove = view.findViewById<ImageView>(R.id.imageViewRemove)

        val cartItem = getItem(position)

        textViewName.text = cartItem.name
        textViewPrice.text = cartItem.price.toString()
        textViewQuantity.text = cartItem.quantity.toString()

        // "+" 버튼 클릭 리스너
        imageViewPlus.setOnClickListener {
            cartItem.quantity++
            textViewQuantity.text = cartItem.quantity.toString()
            notifyDataSetChanged() // 데이터가 변경되었음을 어댑터에 알림
            onQuantityChange() // 콜백 함수 호출
        }

        // "-" 버튼 클릭 리스너
        imageViewMinus.setOnClickListener {
            if (cartItem.quantity > 0) {
                cartItem.quantity--
                textViewQuantity.text = cartItem.quantity.toString()
                notifyDataSetChanged() // 데이터가 변경되었음을 어댑터에 알림
                onQuantityChange() // 콜백 함수 호출
            }
        }

        imageViewRemove.setOnClickListener {
            cartItem.quantity = 0
            cartItems.removeAt(position) // cartItems에서 제거
            notifyDataSetChanged() // 데이터 변경을 알리기 위해 어댑터 갱신
            onQuantityChange() // 콜백 함수 호출
        }

        return view
    }
}
