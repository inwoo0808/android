fun main() {
    var obj1 = TestClass1() // 1. 주생성자 프로퍼티가 있는데 객체 생성하면서 매개변수를 전달하지 않는다? (주생성자는 무조건 호출해야 하는데)
    obj1.testMethod1() // 3. 메서드 호출

    var obj2 = SubClass() // 8. SubClass의 객체 생성
    obj2.subMethod1() // 11. SubClass의 subMethod1() 호출
}

class TestClass1(var a2: Int) {
    var a1 = 100

    constructor() : this(100) { // 2. 보조생성자에서 주생성자를 호출한다.

    }

    fun testMethod1() {
        var a1 = 200 // 4. 메서드 내부에 같은 이름의 변수 a1을 또 선언한다?
        println("a1: $a1") // 5. 메서드 내부의 변수가 호출된다.
        println("this.a1: ${this.a1}") // 6. 객체의 프로퍼티가 호출된다.

        fun testMethod2() { // 7. 메서드도 마찬가지
            println("testMethod1 내부의 testMethod2()")
        }

        testMethod2()
        this.testMethod2()
    }

    fun testMethod2() {
        println("testMethod2()")
    }
}

open class SuperClass(var a2: Int) {
    open var a1 = 100

    open fun superMethod1() {
        println("SuperClass superMethod1")
    }
}

class SubClass : SuperClass(200) { // 9. 수퍼클래스의 주생성자를 호출한다. a2는 200.
    override var a1 = 1000 // 10. a1 오버라이드. a1은 1000.

    fun subMethod1() { // 12. 호출됨.
        println("a1: $a1") // 13. "a1: 1000"
        println("super.a1: ${super.a1}") // 14. "a1: 100"

        superMethod1() // 15. "SuperClass superMethod1", "SubClass superMethod1"
        super.superMethod1() // 16. "SuperClass superMethod1"
    }

    override fun superMethod1() {
        super.superMethod1()
        println("SubClass superMethod1")
    }
}

class SubClass2 : SuperClass { // 17. 상속 후 보조생성자를 만들 경우 부모의 주생성자를 호출해야 한다.
    constructor(a1: Int) : super(a1)

    constructor(a1: Int, a2: Int) : super(a1)
}