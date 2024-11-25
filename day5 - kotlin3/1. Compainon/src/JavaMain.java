public class JavaMain {
    public int javaA1 = 100;
    public static int javaA2 = 200;
    public void javaMethod1() {
        System.out.println("javaMethod1");
    }
    public static void javaMethod2() {
        System.out.println("javaMethod2");
    }
    public static void main(String[] args) { // 8. 자바 메인을 실행한다.
        TestClass1 t1 = new TestClass1();
        System.out.printf("t1.a1: %d\n", t1.getA1()); // 9. 일반 변수에 게터로 접근한다.
        t1.testFun1();

//        System.out.printf("TestClass1.a2: %d\n", TestClass1.a2); // 10. 자바에서 코틀린 컴패니언으로 접근은 클래스로 접근하더라도 그냥 접근할 수 없다.
//        TestClass1.testFun2();
        System.out.printf("TestClass1.a2: %d\n", TestClass1.Companion.getA2()); // 11. 클래스로 접근하면서 ".Compaion"으로 접근해야 한다.
        TestClass1.Companion.testFun2();

        System.out.printf("TestClass1.a3: %d\n", TestClass1.getA3()); // 12. 코틀린 Compaion 멤버에 접근할 때 "@JvmStatic"로 선언해 놓으면 그냥 접근이 가능하다.
        TestClass1.testFun3();
    }
}
