fun main() {
    val view = View("view1", 100, 200)
    val onClickListener = OnClickListener1()
    view.registerOnClickListener(onClickListener)
    view.clicked()

    val view2 = View("view2", 300, 100)
    val onClickListener2 = OnClickListener2()
    view2.registerOnClickListener(onClickListener2)
    view2.clicked()
}

class OnClickListener1 : View.OnClickListener {
    override fun onClick(view: View) {
        println("안녕하세요. 저는 ${view.id}입니다.")
    }
}

class OnClickListener2 : View.OnClickListener {
    override fun onClick(view: View) {
        println("Hello. I'm ${view.id}.")
    }
}

class View(val id: String, val width: Int, val height: Int) {
    var onClickListener : OnClickListener? = null

    init {
        draw()
    }

    fun draw() {
        println("뷰가 생성되었습니다. 가로: $width, 세로: $height")
    }

    fun clicked() {
        onClickListener?.onClick(this)
    }

    fun registerOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(view: View)
    }
}
