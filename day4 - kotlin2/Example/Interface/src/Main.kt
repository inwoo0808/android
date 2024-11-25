fun main() {
    val mainActivity = MainActivity()
    mainActivity.run()
}

interface Button {
    var size: Int
    fun click()
}

interface TextView {
//    var size: Int
    var text: String
}

class MainActivity : Button, TextView {
    fun run() {
        // 버튼
        size = 100
        click()

        // 텍스트뷰
        text = "저는 텍스트뷰에요."
    }

    override var size: Int = 0
        get() = field
        set(value) {
            field = value
        }

    override var text: String = ""
        get() = field
        set(value) {
            field = value
            println(field)
        }

    override fun click() {
        println("버튼이 클릭 되었어요. 크기는 ${size}입니다.")
    }
}