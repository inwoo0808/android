/** 고객이 배기음을 커스텀 할 수 있는 자동차를 판매
 * 나는 자동차를 만드는 회사다.
 * 고객은 배기음을 커스텀 할 수 있다.
 */

fun main() {
    // ------ 자동차 제조사 영역 ------

    // A에게 판매하는 자동차를 만든다
    val carA = Car("David")

    // B에게 판매하는 자동차를 만든다
    val carB = Car("Jason")


    // ------ 고객A 영역 ------
    val soundCustomizerA = SoundCustomizerA()
    carA.setSound(soundCustomizerA)
    carA.drive()

    // ------ 고객B 영역 ------
    val soundCustomizerB = SoundCustomizerB()
    carB.setSound(soundCustomizerB)
    carB.drive()
}

// ------ 자동차 제조사 영역 ------
// 고객이 배기음을 커스텀할 수 있게 만든 자동차 설계도
class Car(val owner: String) {
    var soundCustomizer : SoundCustomizer? = null

    init {
        make()
    }

    fun make() {
        println("${owner}에게 판매하는 자동차가 만들어졌습니다.")
    }

    fun drive() {
        if (soundCustomizer != null) {
            soundCustomizer!!.vRoom(this)
        }
    }

    fun setSound(soundCustomizer: SoundCustomizer) {
        this.soundCustomizer = soundCustomizer
    }

    interface SoundCustomizer {
        fun vRoom(car: Car)
    }
}


// ------ 고객 영역 ------

// A가 설계한 배기음 시스템 설계도
class SoundCustomizerA : Car.SoundCustomizer {
    override fun vRoom(car: Car) {
        println("저는 ${car.owner}의 자동차입니다. 부르릉~ 부르릉~~")
    }
}

// B가 설계한 배기음 시스템 설계도
class SoundCustomizerB : Car.SoundCustomizer {
    override fun vRoom(car: Car) {
        println("나는 ${car.owner}님의 자동차다!! 쾅쾅쾅쾅쾅쾅쾅!!!!")
    }
}


// 더 나아간다면, SoundCustomizer 말고도 LightCustomizer 등을 추가로 붙일 수 있도록 설계할 수 있다.
// LightCustomizer 추가하는 것은 리팩토링 퀴즈로.