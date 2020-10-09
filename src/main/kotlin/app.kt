import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val first = async { firstNumber()
            thirdNumber()
            secondNumber()}
//        val second = async { secondNumber() }
//        val third = async { thirdNumber() }
//
//        val result = first.await() + second.await() + third.await()
       println(first)
    }

    println(time) //prints 7 seconds
}
suspend fun firstNumber(): Int {
    println("threadname: "+Thread.currentThread().name.toString())
    delay(3_000) // 3 seconds delay
    return 5
}
suspend fun secondNumber(): Int {
    println("threadname: "+Thread.currentThread().name.toString())
    delay(5_000) // 5 seconds delay
    return 8
}
suspend fun thirdNumber(): Int {
    println("threadname: "+Thread.currentThread().name.toString())
    delay(7_000) // 7 seconds delay
    return 10
}