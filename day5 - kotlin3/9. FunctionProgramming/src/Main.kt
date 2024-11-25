fun main() {
    val r1 = testFun1(100, 200)
    println(r1)
    val r2 = testFun2(100, 200)
    println(r2)
    val r3 = testFun3(100, 200)
    println(r3)

    println("----------------")

    val lambda1: (Int, Int) -> Int = { a1: Int, a2: Int -> a1 + a2 }
    val lambda2 = { a1: Int, a2: Int ->
        println("$a1, $a2")
        a1 + a2
    }
    val lambda3: (a1: Int, a2: Int) -> Int = { a1, a2 -> a1 + a2 }
    println(lambda1(10, 20))
    println(lambda2(10, 20))
    println(lambda3(10, 20))

    println("----------------")

    println(testFun4( 10, 20))

    val lambda4 = { a1: Int, a2: Int ->
        val r10 = a1 + a2
        val r20 = a1 - a2
        r1 * r2
    }
    val r8 = lambda4(10, 20)
    println(r8)

}

fun testFun1(a1: Int, a2: Int) : Int {
    return a1 + a2
}

fun testFun2(a1: Int, a2: Int) : Int = a1 + a2
fun testFun3(a1: Int, a2: Int) = a1 + a2

fun testFun4(a1: Int, a2: Int) : Int {
    val r1 = a1 + a2
    val r2 = a1 - a2
    val r3 = r1 * r2
    return r3
}