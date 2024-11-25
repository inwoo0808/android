fun main() {

    /** Interface
     * 클래스나 객체가 특정 동작을 구현하도록 강제하는 일종의 계약입니다.
     * 인터페이스는 추상 메서드와 프로퍼티만을 선언하며, 이를 구현하는 클래스는 해당 메서드와 프로퍼티를 구현해야 합니다.
     * 인터페이스는 다중 상속이 가능하여, 다양한 기능을 조합할 때 유용합니다.
     */

    // 추상클래스
    val obj1 = TestClass1() // 1. 객체 생성
    val obj2 = TestClass2()
    testFun1(obj1)
    testFun2(obj2)

    println("------------------------------")

    // 인터페이스 - 각자 구현
    val obj3 = TestClass3() // 5. 객체 생성
    val obj4 = TestClass4()
    testFun3(obj3)
    testFun4(obj4)

    println("------------------------------")

    // 인터페이스 - 여러개의 인터페이스를 구현할 수 있다.
    val obj5 = TestClass5()
    testFun3(obj5)
    testFun4(obj5)

    println("-------------예제---------------")


}

abstract class AbstractClass1 {
    abstract fun abstractMethod1()
}

abstract class AbstractClass2 {
    abstract fun abstractMethod2()
}

fun testFun1(obj: AbstractClass1) { // 3. 추상클래스의 객체로 구현체 접근 가능
    obj.abstractMethod1()
}

fun testFun2(obj: AbstractClass2) { // 4. 여러개의 추상클래스를 하나의 클래스로 구현하지 못 한다. 각자 구현해야 한다.
    obj.abstractMethod2()
}

class TestClass1 : AbstractClass1() { // 2. 추상클래스 구현
    override fun abstractMethod1() {
        println("TestClass1의 abstractMethod1()")
    }
}

class TestClass2 : AbstractClass2() {
    override fun abstractMethod2() {
        println("TestClass2의 abstractMethod2()")
    }
}


interface Inter1 {
    fun inter1method1() {
        println("Inter1의 inter1method1()")
    }
    fun inter1method2()
}

interface Inter2 {
    fun inter2method1() {
        println("Inter2의 inter1method1()")
    }
    fun inter2method2()
}

fun testFun3(obj: Inter1) {
    obj.inter1method1()
    obj.inter1method2()
}

fun testFun4(obj: Inter2) {
    obj.inter2method1()
    obj.inter2method2()
}

class TestClass3 : Inter1 { // 6. 인터페이스 구현
    override fun inter1method2() {
        println("TestClass3의 inter1method2()")
    }
}

class TestClass4 : Inter2 {
    override fun inter2method2() {
        println("TestClass4의 inter2method2()")
    }
}

// 7. 여러개의 인터페이스 구현. TestClass5는 총 4개의 메서드를 갖게 된다. Inter1과 Inter2로 각 메서드에 접근할 수 있다.
class TestClass5 : Inter1, Inter2 {
    override fun inter1method2() {
        println("TestClass5의 inter1method2()")
    }

    override fun inter2method2() {
        println("TestClass5의 inter2method2()")
    }
}