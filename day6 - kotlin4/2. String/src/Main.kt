fun main() {
    val str1 = "안녕하세요"
    println(str1[0])
//    str1[0] = "반"

    println("--------------------")

    val str2 = str1.substring(1..3)
    println(str2)

    val str3 = "Hello World"
    val str4 = "hello world"
    println(str3.compareTo(str4))
    println(str4.compareTo(str3))
    println(str4.compareTo(str3, true))
    println(str4.contentEquals(str3))

    println("--------------------")

    val str5 = "ab cd ef gh"
    val r5 = str5.split(" ")
    println(r5)

    println("--------------------")

    val str6 = "abc"
    val str7 = str6 + "def"
    println(str6)
    println(str7)

    val buffer1 = StringBuffer()
    buffer1.append("abc")
    buffer1.append(100)
    buffer1.append(11.11)
    println(buffer1)

    buffer1.insert(3, "테스트")
    buffer1.insert(4, 33.33)
    println(buffer1)

    buffer1.delete(3, 6)
    println(buffer1)

}