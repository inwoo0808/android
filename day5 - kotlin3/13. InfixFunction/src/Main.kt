fun main() {
    val r1 = 100 add 50
    println("r1: $r1")
}

infix fun Int.add(a1: Int) : Int {
    return  this + a1
}