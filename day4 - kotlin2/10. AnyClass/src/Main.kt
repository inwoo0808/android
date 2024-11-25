fun main() {
    val obj1 = TestClass1()
    println("obj1: $obj1")

    val obj2 = TestClass2()
    val obj3 = TestClass3()
    testFun1(obj1)
    testFun1(obj2)
    testFun1(obj3)
}

class TestClass1 {
    // Any 클래스의 메서드
    override fun toString(): String {
        return "TestClass1의 객체입니다."
    }
}

class TestClass2 {
    override fun toString(): String {
        return "TestClass2의 객체입니다."
    }
}

class TestClass3 {
    override fun toString(): String {
        return "TestClass3의 객체입니다."
    }
}

fun testFun1(a1: Any) {
    println("a1: $a1")
}