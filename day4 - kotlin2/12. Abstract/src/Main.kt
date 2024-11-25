fun main() {

    /** 추상 클래스 Abstract
     * 하나 이상의 추상 메서드(구현되지 않은 메서드)를 포함하는 클래스를 의미합니다.
     * 추상 클래스는 직접 객체를 생성할 수 없으며, 다른 클래스에서 상속받아 구현해야 합니다.
     * 추상 클래스는 클래스의 공통 기능을 정의하고, 자식 클래스에서 세부 동작을 구현하도록 강제할 수 있습니다.
     */

    val obj1 = Super1() // 1. 객체 생성
    testFun1(obj1) // 2. Super1의 프로퍼티 메서드 실행

    println("-----------------------")

    val obj2 = Sub1() // 3. Super1의 상속 객체 생성
    testFun1(obj2) // 4. 수행

    println("-----------------------")

    val sub2 = Sub2()
    sub2.method1()
    sub2.method2()
}

open class Super1 {
    fun method1() {
        println("Super1 클래스의 method1()")
    }

    open fun method2() {
        println("Super1 클래스의 method2()")
    }
}

class Sub1 : Super1() {
    override fun method2() {
        println("Sub1 클래스의 method2()")
    }
}

fun testFun1(ob1: Super1) {
    ob1.method1() // 5. 부모의 메서드 수행
    ob1.method2() // 6. 자식의 메서드 수행
}

abstract class Super2 {
    fun method1() { // 8. 추상클래스 안에 일반 메서드를 구현할 수 있다.
        println("Super2 클래스의 method1()")
    }

    abstract fun method2() // 7. 추상 메서드는 수행문을 구현하지 않는다.
}

class Sub2 : Super2() {
    override fun method2() { // 9. 추상메서드를 구현한다.
        println("Sub2 클래스의 method2()")
    }
}