fun main() {
    testFun1()
    testFun1()
    testFun2()
    testFun2()
}

fun testFun1() {
    println("---------------")
    println("testFun1")
    println("---------------")
}

inline fun testFun2() {
    println("---------------")
    println("testFun2")
    println("---------------")
}