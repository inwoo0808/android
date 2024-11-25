package com.example.button2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// 왜 안드로이드에서 이렇게 설계를 해놨냐 이거지
// - 안드로이드에서 뷰를 설계할 때, 뷰가 클릭됐을 때 수행되는 코드를 사용자가 직접 작성하게 할 수 있도록
// - 뷰라는 클래스에는 화면에 그리는 기능, 사용자의 입력을 받는 기능(터치 등) 등이 설계되어 있겠지.
// - 특정 기능은 사용자가 직접 만들도록. 이렇게 얘기했을 때 딱 생각나는 것. "인터페이스"를 활용해야지!
// -

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myOnClickListener = MyOnClickListener()

        val view = findViewById<View>(R.id.view) // 뷰 객체
        view.setOnClickListener(myOnClickListener)






        val myView = MyView(100, 100)

        val my3OnClickListener = My3OnClickListener()
        val myView3 = View3()
        myView3.setOnClickListener(my3OnClickListener)
    }
}

class MyOnClickListener : View.OnClickListener {
    override fun onClick(p0: View?) {
        Toast.makeText(p0!!.context, "뷰가 클릭 되었습니다.", Toast.LENGTH_SHORT).show()
    }

}








class My3OnClickListener : View3.OnClickListener {
    override fun onClick() {
        println("MyView를 클릭했습니다.")
    }
}

// 뷰를 내가 안드로이드 플랫폼 설계자라고 생각하고 디자인 해보자.
interface View2 {
    var width: Int
    var height: Int

    fun draw() {
        // TODO: width와 height을 가지고 화면에 뷰를 그린다.
    }

    fun onClick()
}

class MyView(override var width: Int, override var height: Int) : View2 {
    override fun onClick() {
        println("MyView를 클릭했습니다.")
    }

}

// 위 코드처럼 사용자가 직접 onClick() 메서드를 구현해서 원하는 동작을 수행하도록 할 수 있다.
// 하지만 이렇게 하면 매번 뷰를 모두 클래스를 만들어야 한다.
// 그래서 안드로이드 View 클래스 안에 인터페이스를 만들어놓았다. OnClickListener

class View3 {
    var width: Int = 0
    var height: Int = 0
    lateinit var listener: OnClickListener

    fun draw() {
        // TODO: width와 height을 가지고 화면에 뷰를 그린다.
    }

    // 실제 사용자가 View3를 클릭했을 때 수행되는 코드
    fun onClick() {
        listener.onClick()
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        listener = onClickListener
    }

    interface OnClickListener {
        fun onClick()
    }
}