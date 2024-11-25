import com.keon.module.pkg2.*
import com.keon.pkg1.*

fun main() {
    // 자바 코드로 보기
    val obj = Class(100, 200)
    println(obj.a1)
    println(obj.a2)
    println(obj.a3)

    println("-------------------")

    // 같은 패키지 내
    val obj1 = PrivateClass1()
    val obj2 = PublicClass1()
    val obj3 = ProtectedClass1()
    val obj4 = InternalClass1()

    // 다른 패키지
    val obj5 = PrivateClass2()
    val obj6 = PublicClass2()
    val obj7 = ProtectedClass2()
    val obj8 = InternalClass2()

    // 다른 모듈
    val obj11 = PrivateClass3()
    val obj12 = PublicClass3()
    val obj13 = ProtectedClass3()
    val obj14 = InternalClass3()

    println("-------------------")

    val t1 = TestClass1()
    t1.private1
    t1.public1
    t1.protected1
    t1.internal1

}

class Class(val a1: Int, var a2: Int) {
    var a3: Int = 0
}


/** 클래스에서의 접근 제한자
 * private: 외부에서 객체를 생성할 수 없다.
 * public: 외부에서 객체를 생성할 수 있다.(default)
 * protected: 클래스에 지정할 수 없다.
 * internal: 같은 모듈일 경우에만 객체를 생성할 수 있다.
 */

/** 변수, 메서드에서의 접근 제한자
 * private: 외부에서 접근할 수 없다.
 * public: 외부에서 접근할 수 있다.(default)
 * protected: 상속 관계일 때만 접근이 가능하다.
 * internal: 같은 모듈일 경우에만 접근이 가능하다.
 */

class SubClass1 : TestClass1() {
    fun subMethod1() {
        private1
        public1
        protected1
        internal1
    }
}
