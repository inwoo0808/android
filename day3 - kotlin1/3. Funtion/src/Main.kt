fun main() {

    /**
     * Function
     * - 코드를 미리 작성해놓고 필요할 때 불러 쓰는 개념
     */

    /*fun 함수명(매개변수) : 반환값 타입 {
        코드들...
    }*/

    // 함수 호출
    test1()

    var result: Int
    result = add(200, 100)
    println("더하기 결과값은 ${result}입니다.")

    var result2: Int
    result2 = minus()
    println("빼기 결과값은 ${result2}입니다.")
    result2 = minus(200)
    println("빼기 결과값은 ${result2}입니다.")

    // 함수의 오버로딩
    function()
    function(100)
    function(100.00)
    function(100, 200)

    outer()
}

/// 기본 함수
fun test1() {
    println("test1 함수 호출")
}

// 매개변수, 반환값이 있는 함수
fun add(a: Int, b: Int) : Int {
    return a + b
}

// 기본 매개변수 값을 설정
fun minus(a: Int = 200, b: Int = 100) : Int {
    return a - b
}

/**
 * 함수의 오버로딩
 * - 함수의 이름은 같지만 매개변수 자료형이 다르거나 매개변수의 갯수가 다를 수 있다.
 */

fun function() {
    println("매개변수 없을 때")
}

fun function(a: Int) {
    println("매개변수가 하나이고 정수형일 때 ${a}")
}

fun function(a: Double) {
    println("매개변수가 하나이고 실수형일 때 ${a}")
}

fun function(a: Int, b: Int) {
    println("매개변수가 두 개일 때 ${a}, ${b}")
}

/**
 * 지역함수
 * - 함수 안에 함수 정의 및 호출
 * - 함수 밖에서는 호출 안됨
 */

fun outer() {
    println("함수 outer 호출")

    fun inner() {
        println("함수 inner 호출")
    }

    inner()
}