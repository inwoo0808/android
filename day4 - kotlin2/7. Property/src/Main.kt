/** Property 프로퍼티
 * 객체의 변수를 외부에서 바로 접근하지 못하게 하는 것을 캡슐화라고 하고
 * 이런 변수에 getter, setter를 설정해주게 되면 Property라고 할 수 있다.
 */

fun main() {
    val obj1 = TestClass2(100, 200)
    println(obj1.a1)
    println(obj1.a2)

    obj1.a1 = 1000
    println(obj1.a1)

    val obj3 = TestClass3()
    obj3.v1 = 3000
//    obj3.v2 = 4000


    obj3.v3 = 5000
    println(obj3.v3)
}

class TestClass1(a1: Int, a2: Int) {

}

/**
 * 주생성자
 * var: Java 코드로 변환하면 getter, setter가 모두 셋팅된다.
 * val: Java 코드로 변환하면 getter만 셋팅된다.
 * 멤버 변수도 마찬가지
 */
class TestClass2(var a1: Int, val a2: Int) {
    var v1: Int = a1
    val v2: Int = a2
}

class TestClass3 {
    var v1: Int = 0
    val v2: Int = 0
    var v3: Int = 100
        get() {
            println("v3 get() 호출")
            return field
        }
//        get() = field // 한 줄로 구현 가능
        set(value) {
            println("v3 set() 호출")
            field = value
        }
}

class TestClass4(var a1: Int, val a2: Int) {
    constructor(a1: Int, a2: Int, a3: Int) : this(a1, a2) {

    }
}