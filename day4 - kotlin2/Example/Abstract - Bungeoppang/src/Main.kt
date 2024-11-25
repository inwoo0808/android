fun main() {

    /** 클래스, 객체, 추상클래스 연습
     * - 붕어빵
     */

    val fishBread1 = FishBread()
    fishBread1.make("팥앙금")

    val fishBread2 = FishBread()
    fishBread2.make("슈크림")

}

class FishBread {
    var sauce = ""

    fun make(sauce: String) {
        this.sauce = sauce
        println("${this.sauce} 붕어빵이 만들어졌어요")
    }
}

// 이제 이 기본 붕어빵틀을 1가지 기능을 원하는데로 커스텀 할 수 있게 개량해서 판매한다.
// - 어떤 기능? -> 붕어빵을 구울 때 전구가 켜지는 붕어빵틀. 다만 전구 색상은 기계를 산 사장님들이 알아서 커스텀 할 수 있다. 그리고 꼭 커스텀을 해야한다.
// - 아니면 인덕션 옵션을 할 건지, 가스불 옵션을 할건지 커스텀 할 수 있게.

abstract class NewFishBread {
    var sauce = ""

    fun make(sauce: String) {
        this.sauce = sauce
        println("${this.sauce} 붕어빵이 만들어졌어요")
    }

    abstract fun setFire()
}

class FireFishBread : NewFishBread() {
    override fun setFire() {
        TODO("Not yet implemented")
    }
}