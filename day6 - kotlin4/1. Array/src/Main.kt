fun main() {
    val array1 = arrayOf(10, 20, 30, 40, 50)
    println(array1)
    println(array1.contentToString())

    val array2 = arrayOf(100, 11.11, "스트링")
    println(array2.contentToString())

    val array3 = intArrayOf(10, 20)
    val array4 = doubleArrayOf(11.22, 22.33)
//    val array5 = arrayOf<String>("문자열", 1)

    println("-----------------------")

    val array6 = Array(5, {0})
    println(array6.contentToString())

    val array7 = Array(5) { it * 2 }
//    val array7 = Array(5)
    println(array7.contentToString())

    println("-----------------------")

    for (item in array1) {
        println(item)
    }

    println("-----------------------")

    val array8 = arrayOf(arrayOf(10, 20), arrayOf(30, 40), arrayOf(50, 60))
    println(array8.contentToString())
    println(array8.contentDeepToString())

    for (item in array8) {
        for (itme2 in item) {
            println(itme2)
        }
    }

    println("-----------------------")

    println(array1[0])
    println(array1[1])
    println(array1[2])
    println(array1[3])
    println(array1[4])

    println(array1.get(0))

    println("-----------------------")

    array1[0] = 100
    array1.set(1, 200)
    println(array1.contentToString())

    println("-----------------------")

    println(array1.size)

    println("-----------------------")

    /** 제공 대표 메서드
     * plus
     * sliceArray
     * first
     * last
     * indexOf
     * average
     * count
     * contains
     * sortedArray : 오름차순
     * sortedArrayDescending : 내림차순
     */

    val array10 = array1.plus(60)
    println(array10.contentToString())
    val array11 = array1.sliceArray(1..3)
    println(array11.contentToString())
    println(array1.first())
    println(array1.last())
    println(array1.indexOf(30))
    println(array1.average())
    println(array1.sum())
    println(array1.count())
    println(array1.contains(30))
    println(30 in array1)
    val array12 = array1.sortedArray()
    println(array12.contentToString())
    val array13 = array1.sortedArrayDescending()
    println(array13.contentToString())
    println(array1.max())
    println(array1.min())


}