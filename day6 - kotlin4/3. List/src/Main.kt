fun main() {
    val list1 = listOf(10, 20, 30, 40, 50)
//    val list1 = listOf<Int>()
    val list2 = listOf("문자열1", "문자열2", "문자열3")
    println(list1)
    println(list2)

    val list3 = mutableListOf<Int>()
    val list4 = mutableListOf("문자열1", "문자열2", "문자열3")
    println(list3)
    println(list4)

    val list5 = emptyList<Int>()
    val list6 = listOfNotNull(10, 20, null, 30)
    println(list6)

    for (item in list1) {
        println(item)
    }

    println(list1.size)

    println("---------------")

    println(list1[0])
    println(list1.get(0))

    println("---------------")

    val list7 = listOf(10, 20, 30, 10, 20, 30)
    val index1 = list7.indexOf(20)
    val index2 = list7.lastIndexOf(20)
    println(index1)
    println(index2)

    val list8 = list7.subList(1, 3)
    println(list8)

    println("---------------")

    println(list3)
    list3.add(10)
    list3.add(20)
    list3.add(30)
    list3.addAll(listOf(10, 20, 30))
    println(list3)

    list3.add(1, 100)
    println(list3)

    list3.addAll(2, listOf(200, 300))
    println(list3)

    list3.remove(100)
    println(list3)

    list3.removeAll(listOf(100, 200))
    println(list3)

    list3.removeAt(3)

    list3.set(2, 1000)
    list3[2] = 1000

    println("---------------")

    val list100 = list1.toMutableList()
    list100.add(1000)

    val list200 = list100.toList()
//    list200.add()


}