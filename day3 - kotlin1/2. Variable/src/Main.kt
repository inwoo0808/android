fun main() {

    // 리터럴은 값 자체
    // 보통 변수에 저장되는 값 자체를 리터럴이라고 한다.

    println("Hello World!") // "Hello World!"가 리터럴. 문자열 리터럴
    println(100) // 100"가 리터럴. 정수 리터럴

    // 정수 리터럴
    println(222_222_222_222_222) // 자릿수 구분하기 쉽게

    // 실수 리터럴
    println(33.33) // "F" 없으면 더블형 변수 -> 8바이트
    println(22.22) // "F" 있으면 플롯형 변수 -> 4바이트

    // 문자열 리터럴
    println("안녀어어어엉!!!") // 쌍따옴표

    // 문자 리터럴
    println('A') // 작은 따옴표
    println('가')

    // 논리 리터럴
    println(true)
    println(false)

    // Raw String
    println("""
        여러줄을 작성할 수 있어요.
        할 수 있다니까요?!
    """)
    println("""
        여러줄을 작성할 수 있어요.
        할 수 있다니까요?!
    """.trimIndent())


    /** 코틀린에서는 변수를 선언할 때 두 가지 키워드를 사용한다.
     * var : 선언 이후 값을 다시 저장할 수 있다.
     * val : 선언 이후 값을 다시 저장할 수 없다.
     */

    val text: String = "val"
    var text2: String = "var"
//    text = "a"
    text2 = "b"

    /// 자료형 생략 가능
    val variable = "variable"
    var integer = 3

    /**
     * 리터럴 문자열과 함께 사용
     */
    println("리터럴 ${variable}입니다.")
    println("리터럴 $integer 입니다.")

    println("리터럴 " + integer + "입니다.") // 자바처럼 사용도 가능

    /**
     * null 허용 변수, 허용하지 않는 변수
     */
//    var a: String = null
    val b: String? = null
    println(b)

}
