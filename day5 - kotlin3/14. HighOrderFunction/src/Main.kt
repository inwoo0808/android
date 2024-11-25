fun main() {
    val t1 = fun(x1: Int, x2: Int): Int {
        return x1 + x2
    }

    testFun2(t1, 100, 200)

    testFun2(fun(x1: Int, x2: Int): Int {
        return x1 - x2
    }, 100, 200)

    val lambda1 = { x1: Int, x2: Int -> x1 * x2 }
    testFun2(lambda1, 100, 200)

    testFun2({ x1: Int, x2: Int -> x1 / x2 }, 100, 200)

    val t2 = testFun3()
    val r2 = t2(100, 200)
    println("r2: $r2")

    val t3 = testFun4()
    val r3 = t3(100, 200)
    println("r3: $r3")

    println("-------------------")

    testFun5({ x1: Int -> x1 + 100}, 200)
    testFun5({it + 100}, 200)

    testFun6(100, 200, { x1: Int, x2: Int -> x1 + x2 })
    testFun6(100, 200) { x1: Int, x2: Int ->
        x1 + x2
    }
    testFun6(100, 200) { x1, x2 ->
        x1 + x2
    }

    testFun7({ x1: Int -> println(x1) })
    testFun7 { println(it) }
    testFun7 { it ->
        println(it)
    }
}

fun testFun1(a1: Int, a2: Int, m1: () -> Unit) {

}

fun testFun2(m1: (Int, Int) -> Int, a1: Int, a2: Int) {
    val r1 = m1(a1, a2)
    println(r1)
}

fun testFun3(): (Int, Int) -> Int {
    return fun(x1: Int, x2: Int): Int {
        return x1 + x2
    }
}

fun testFun4(): (Int, Int) -> Int {
    return { x1: Int, x2: Int -> x1 - x2 }
}

fun testFun5(m1: (Int) -> Int, a1: Int) {
    val r5 = m1(a1)
    println("r5: $r5")
}

fun testFun6(a1: Int, a2: Int, m1: (Int, Int) -> Int) {
    val r6 = m1(a1, a2)
    println("r6: $r6")
}

fun testFun7(m1: (Int) -> Unit) {
    m1(100)
}