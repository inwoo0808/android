import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main() {
    // Thread 클래스를 상속받은 클래스는 쓰드를 가동하는
    // start() 메서드를 가지고 있기 때문에 객체 생성하고 start()를 호출해 주면 된다.
    val thread1 = ThreadClass1()
    thread1.start()

    // Runnable 인터페이스를 구현한 클래스는 start() 메서드가 없기 때문에
    // Thread 클래스의 객체를 생성하여 이를 통해 가동한다.
    val thread2 = ThreadClass2()
    val thread3 = Thread(thread2)
    thread3.start()

    // thread 고차함수 이용
    // run 메서드에 들어갈 코드(쓰래드로 처리될 코드)를
    // 익명함수나 람다식으로 작성해서 넣어주면 해당 코드를 쓰래드로 운영해준다.
    // start 메서드를 호출하지 않아도 된다.
    thread {
        for (a1 in 1..10) {
            sleep(100)
            println("thread3")
        }
    }
}

// Thread를 상속받은 클래스
class ThreadClass1 : Thread() {
    override fun run() {
        super.run()

        for (a1 in 1..10) {
            Thread.sleep(100)
            sleep(100)
            println("thread1")
        }
    }
}

// Runnable 인터페이스를 구현한 클래스
class ThreadClass2 : Runnable {
    override fun run() {
        for (a1 in 1..10) {
            sleep(100)
            println("thread2")
        }
    }
}