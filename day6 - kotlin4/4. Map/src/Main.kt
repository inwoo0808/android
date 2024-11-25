fun main() {
    val map1 = mapOf<String, Int>("key1" to 10, "key2" to 20, "key3" to 30)
//    map1["key1"] = 100
//    map1.set()
    println(map1)

    val map2 = mutableMapOf<String, Int>()
    map2["key1"] = 100
    map2.set("key1", 10)
    println(map2)

    val map3 = mutableMapOf<String, Any>("key1" to 10, "key2" to 22.22, "key3" to true)
    println(map3)

    println("----------------")

    println(map1.get("key1"))

    println(map1["key1"])

    println("----------------")

    println(map1.size)
    println(map1.keys)
    println(map1.values)

    println(map1.containsKey("key1"))

    println(map1.containsValue(10))

    println("----------------")

    println(map2)
    map2.put("key1", 100)
    map2["key2"] = 200
    println(map2)
    map2["key1"] = 1000
    println(map2)

    map2.remove("key1")
    println(map2)

    val map100 = map1.toMutableMap()
    map100["key100"] = 10000
    println(map100)

    val map200 = map100.toMap()
//    map200["key100"] = 10000
}