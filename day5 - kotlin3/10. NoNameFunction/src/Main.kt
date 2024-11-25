fun main() {
    testFun1()

//    val testFun2 = testFun1
//    val testFun2 = testFun1() // 이건 함수를 복사하는 게 아닌 결과값을 반환하는 것.
    val testFun2 = fun() {
        println("testFun2()")
    }
    testFun2()
}

fun testFun1() {
    println("testFun1()")
}