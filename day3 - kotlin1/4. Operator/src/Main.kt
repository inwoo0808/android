fun main() {

    /**
     * 연산자
     * - 키보드의 일부를 제외한 대부분의 특수문자를 연산자로 사용한다.
     * - 주어진 값을 정해진 방식에 따라 계산하고 그 값을 되돌려준다.
     * - Kotlin은 함수를 사용하는 방법과 연산자를 사용하는 방법 두 가지를 제공한다.
     *
     * 단항 연산자
     * +a : 부호 관련 == a.unaryPlus()
     * -a : 부호 관련 == a.unaryMinus()
     * !a == a.not()
     * a++ : 증감연산자
     * a-- : 증감연산자
     */

    val a1 = 10
    val r1 = -a1
    println(r1)

    val a2 = true
    val r2 = !a2
    println(r2)

    var a3 = 100
    a3++ // a3 = a3 + 1 와 같다.
    println(a3)

    var a4 = 100
    println(a4++) // 해당 줄의 코드를 먼저 실행하고 1을 증가시켜준다.

    var a5 = 100
    println(++a5) // 먼저 1을 증가시켜준 후 해당 줄의 코드를 실행한다.


    /** 산술 연산자
     * a + b
     * a - b
     * a * b
     * a / b
     * a % b : 나머지
     * a .. b : 범위 연산자
     */

    val range = 1..10 // 도움말을 보면 IntRange로 되어있다.
    println(range)

    /** 대입 연산자
     * a += b : a = a + b -> 부호 순서를 기억하기 쉽게. a =+ b 이면 a = +b로 전혀 다른 표현식이 되어 버린다. 또는 equal("=") 보다 중요한 연산자가 먼저 온다고 생각하면 쉽게 기억할 수 있다.
     * a -= b : a = a - b
     * a *= b : a = a * b
     * a /= b : a = a / b
     * a %= b : a = a % b
     */

    var a6 = 3
    var b6 = 4
    a6 += b6
    println("a6: $a6")


    /** 비교 연산자 : true or false 반환
     * a == b
     * a != b
     * a > b
     * a < b
     * a >= b
     * a <= b
     */

    val a7 = 10
    val b7 = 11
    val c7 = 10
    println("a7 == b7 : ${a7 == b7}")
    println("a7 != b7 : ${a7 != b7}")
    println("a7 == c7 : ${a7 == c7}")

    val r7 = a7 > 20
    val r8 = a7 < 20
    val r9 = a7 >= 10
    val r10 = a7 <= 10
    println("$r7, $r8, $r9, $r10")
}