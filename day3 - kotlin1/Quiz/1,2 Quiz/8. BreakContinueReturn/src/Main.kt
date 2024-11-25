fun main() {

    /** Return
     * 현재 수행중인 함수를 종료하는 구문이다.
     * 함수에 수행할 코드가 남아있더라도 함수를 종료하고 함수를 호출한 쪽으로 되돌아 간다.
     * 반환값이 있을 경우 return 문 다음에 반환값을 작성한다.
     */

    val r1 = test1(100)
    println("r1: $r1")

    val r2 = test2(0)
    println("r2: $r2")


    println("-----------------------------")


    /** Break
     * 가장 가까운 반목문을 종료한다.
     * 반복 횟수가 남아있더라도 종료된다.
     */

    for (item in 1..10) {
        if (item > 5) {
            break
        }
//        if (item > 5) break
        println("itme: $item")
    }


    println("-----------------------------")


    /** Continue
     * 반목문에서 continue 이후에 코드가 더 있더라도 다시 위로 올라가는 구문이다.
     * continue 이후에 코드를 무시하고 다음 반복으로 진행되도록 하는 구문이다.
     */

    for (item in 1..10) {
        if (item % 2 == 0) {
            continue
        }
        println("itme: $item")
    }

}

fun test1(a1: Int) : Int {
    println("test1")
    return a1 + 100
}

fun test2(a1: Int) : Int {
    println("test2")
    if (a1 == 0) {
        return -1
    }
    println("이 부분이 수행될까요?")
    return 100 / a1
}