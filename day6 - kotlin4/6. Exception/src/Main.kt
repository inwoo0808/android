import java.lang.ArithmeticException
import java.lang.NullPointerException

fun main() {
    try {
//        val a1 = 10 / 0

//        val str : String? = null
//        println(str!!.length)

        val str2 = "안녕하세요"
        val a2: Int = str2.toInt()
    } catch (e: ArithmeticException) {
        println("수학적 오류가 발생되었습니다.")
    } catch (e: NullPointerException) {
        println("Null 오류가 발생되었습니다.")
    } catch (e: Exception) {
        println("예외 발생")
        e.printStackTrace()
    }

    println("이 부분이 실행 될까요?")
}