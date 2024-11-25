fun main() {

    /** 조건문
     */

    // 기본 if 문 : if 문의 조건식(변수의 값)이 true일 때만 내부의 코드 실행
    val a = 10
    if (a == 10) {
        println("a는 10입니다.")
    }

    // else 문 : if 또는 else 안에 있는 코드 둘 중에 하나는 무조건 실행
    if (a == 11) {
        println("a는 11입니다.")
    } else {
        println("a는 11이 아닙니다.")
    }

    // else if 문 : 순차적으로 조건을 검사하고 조건식이 참인 내부 코드만 실행. else는 필수 아님. else가 없을 경우 아무 코드도 실행 안 될 수 있음
    if (a == 11) {
        println("a는 11입니다.")
    } else if (a == 12) {
        println("a는 12입니다.")
    } else if (a == 13) {
        println("a는 13입니다.")
    } else {
        println("a는 11이 아닙니다.")
    }

    // 모든 조건을 만족해야 할 경우
    val a2 = 10
    val b2 = 20
    if (a2 == 10 && b2 == 20) {
        println("a2는 10이고, b2는 20입니다.")
    }

    // 하나의 조건만 만족해도 되는 경우
    if (a2 == 10 || b2 == 30) {
        println("a2가 10이거나, 또는 b2가 30입니다.")
    }

    // if문을 활용한 변수 값 설정
    var a3 = 10
    var b3 = ""
    if (a3 == 10) { // 원래 코드
        b3 = "10입니다."
    } else {
        b3 = "10이 아닙니다."
    }
    println("a3는 $b3")

    /// Java와 다른 문법

    var c3 = if (a3 == 10) "10입니다." else "10이 아닙니다." // 쉽게 변수를 선언하면서 조건에 따라 값을 할당할 수 있다. 나중에 null값이 아닐 경우에만 값을 저장하는 등 실무에 매우 유용
    println("a3는 $c3")

    var c4 = if (a3 == 10) // 코드 보기 쉽게 개행
        "10입니다."
    else
        "10이 아닙니다."

    var c5 = if (a3 == 10) { // 중괄호를 통해 코드 보기 쉽게 개행
        println("실행 코드 블럭") // <- 조건식에 만족하면 코드 실행도 가능
        "10입니다." // <- 마지막 값만 변수에 저장됨
    }
    else {
        "10이 아닙니다."
    }
}