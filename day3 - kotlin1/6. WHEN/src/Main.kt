fun main() {

    /** when
     * 자바 또는 다른 대부분의 언어에서 사용하는 switch 문과 비슷하다.
     * break을 사용하지 않고,
     * 정수뿐만 아니라 다양한 타입의 값과 비교할 수 있어 더 유용하고 편리할 수 있다.
     */

    // 기본 문법
    val a = 2
    when (a) {
        1 -> println("a는 1입니다.")
        2 -> println("a는 2입니다.")
        3 -> println("a는 3입니다.")
        else -> println("알 수 없는 숫자")
    }

    // 여러 조건 처리
    when (a) {
        1, 2 -> println("a는 1 또는 2입니다.") // 1 || 2
        3 -> println("a는 3입니다.")
        else -> println("알 수 없는 숫자")
    }

    // 범위 조건
    when (a) {
        in 1..5 -> println("Between 1 and 5")
        in 6..10 -> println("Between 6 and 10")
        else -> println("알 수 없는 숫자")
    }

    // 값 할당. 코드 블럭 실행.
    val b = when (a) {
        1 -> {
            "a는 1입니다."
        }
        2 -> {
            println("코드 블럭 실행")
            "a는 2입니다."
        }
        3 -> "a는 3입니다."
        else -> "알 수 없는 숫자"
    }
    println(b)

    val c = function(1)
    println(c)
}

// 함수형
fun function(a: Int) = when (a) {
    1 -> "1입니다."
    2 -> "2입니다."
    else -> "알 수 없는 숫자"
}