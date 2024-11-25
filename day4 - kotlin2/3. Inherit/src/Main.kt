fun main() {
    val s3 = SubClass3()
    println("s3.subMember3: ${s3.subMember3}")
    s3.subMethod3()

    println("s3.superMember3: ${s3.superMember3}")
    s3.superMethod3()
}

// Java 코드로 디컴파일 해보면 class 앞에 final이 붙는 것을 알 수 있다.
// Java에서 final일 경우에는 상속이 불가능하다. 그러므로 이 클래스는 부모 클래스로 사용할 수 없다는 것을 알 수 있다.
// Kotlin에서 class 앞에 open을 붙여줘야지만 상속이 가능해진다.
class SuperClass
open class SuperClass1 {
    var superMember1 = 100

    fun superMethod1() {
        println("SuperClass1의 메서드입니다.")
    }
}

// 반드시 괄호("()")를 붙여 부모 클래스의 생성자를 호출해줘야 한다.
class SubClass : SuperClass1()

// 괄호 대신 "constructor() : super()"로 부모 클래스 생성자를 호출해 줄 수도 있다.
class SubClass1 : SuperClass1 {
    constructor() : super()
}


// 매개변수가 있을 경우
open class SuperClass2(a1: Int) {
    var superMember1 = 100

    fun superMethod1() {
        println("SuperClass1의 메서드입니다.")
    }
}

// 부모 클래스에 값을 넘겨주어야 한다.
class SubClass2 : SuperClass2(100)


open class SuperClass3 {
    var superMember3 = 100

    fun superMethod3() {
        println("SuperClass3의 메서드입니다.")
    }
}

class SubClass3 : SuperClass3() {
    var subMember3 = 200

    fun subMethod3() {
        println("SubClass3 메서드입니다.")
    }
}


open class SuperClass4(val a1: Int)

class SubClass4 : SuperClass4(100)

class SubClass5 : SuperClass4 {
    constructor() : super(100)
}