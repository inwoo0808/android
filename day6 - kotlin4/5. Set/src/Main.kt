fun main() {
    val set1 = setOf(1, 2, 3, 1)
    println(set1)
    val set2 = mutableSetOf<Int>()
    println(set2)

//    set1[0]
    for (item in set1) {
        println(item)
    }

    println(set1.size)

    set2.add(1)
    set2.add(2)
    println(set2)
    set2.add(1)
    println(set2)
    set2.addAll(listOf(3, 4, 5))
    println(set2)

    set2.remove(1)
    println(set2)

    // 리스트, 뮤터블리스트는 셋 또는 뮤터블셋으로 모두 변환 가능 (새로운 객체로 만든다. 엄밀히 말하면 변환은 아님)
    // 셋, 뮤터블셋은 리스트 또는 뮤터블리스트로 보두 변환 가능 (새로운 객체로 만든다. 엄밀히 말하면 변환은 아님)
}