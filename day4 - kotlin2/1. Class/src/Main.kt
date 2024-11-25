fun main() {

    val obj1: TestClass1 = TestClass1()
    println("obj1: $obj1")

    val obj2 = TestClass2()
    println("obj2: $obj2")

    val obj3 = obj2
    println("obj3: $obj3")

    val obj4 = TestClass3()
    println("obj4.a: ${obj4.a}")
    println("obj4.b: ${obj4.b}")

//    obj4.a = 100
    obj4.b = 200
    println("obj4.b: ${obj4.b}")

    obj4.funA()

}

class TestClass1 {

}

class TestClass2

class TestClass3 {
    // 멤버 변수
    val a = 0
    var b = 1

    // 멤버 메서드
    fun funA() {
        println("funA")
    }
}