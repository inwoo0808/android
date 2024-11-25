// Scope Function
// let, apply, run, with, also
// 생성되어 있는 객체의 프로퍼티나 메서드를 사용할 경우
// 클래스로부터 객체를 생성할 때 사용한다.

fun main() {
    val t1 = TestClass1(100, 200)
    t1.a3 = 300
    t1.a4 = 400
    t1.testMethod1()

    println("-----------------")

    // 이미 생성되어 있는 객체에 scope function을 사용해본다.
    // 안내문구에 it이 나와있으면 it 객체의 주소값이 들어 있다고 생각하면 된다.
    // this가 나와있으면 객체에 포함되는 함수로 생각하면 된다.

    // let
    val t2 = TestClass1(100, 200)
    t2.let {

    }
}

class TestClass1(var a1: Int, var a2: Int) {
    var a3: Int = 0
    var a4: Int = 0

    fun testMethod1() {
        println(a1)
        println(a2)
        println(a3)
        println(a4)
    }
}