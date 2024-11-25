fun main() {
    val obj1 = TestClass1() // 1. 객체 생성
    println("obj1.a1: ${obj1.a1}")
    obj1.testFun1()

    val obj2 = TestClass1()
    println("obj2.a1: ${obj2.a1}")
    obj2.testFun1()

    obj1.a1 = 200
    println("obj1.a1: ${obj1.a1}") // 3. "obj1.a1: 200" -> 200으로 변경됨
    println("obj2.a1: ${obj2.a1}") // 4. "obj1.a1: 100" -> 100으로 그대로

    // 객체를 생성해 멤버에 접근할 수 없다.
    // 클래스 자체로 멤버에 접근할 수 있다.
//    println("obj1.a2: ${obj1.a2}") // 5. 객체로는 접근이 안된다.
//    obj1.testFun2()

    println("TestClass1.a2: ${TestClass1.a2}") // 6. 클래스 자체로 접근한다.
    TestClass1.testFun2()

    println("----------------------------")

    val obj3 = JavaMain() // 자바 객체 생성
    println("obj3.javaA1: ${obj3.javaA1}")
    obj3.javaMethod1()

    println("JavaMain.javaA2: ${JavaMain.javaA2}") // 7. 자바 스태틱 변수, 메서드에도 클래스로 접근할 수 있다.
    JavaMain.javaMethod2()
}

class TestClass1 {
    var a1 = 100

    fun testFun1() { // 2. 수행
        println("testFun1")
        println("a1: $a1")
        println("a2: $a2")
        testFun2()
    }

    companion object {
        var a2 = 1000

        @JvmStatic
        var a3 = 2000

        fun testFun2() {
            println("testFun2")
//            println("a1: $a1")
            println("a2: $a2")
        }

        @JvmStatic
        fun testFun3() {
            println("testFun3")
        }
    }
}