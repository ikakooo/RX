import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) = runBlocking {
//    val time = measureTimeMillis {
////        val first = async { firstNumber() }
////        val second = async { secondNumber() }
////        val third = async { thirdNumber() }
//       // val ikako = async{ fetchDocs()}
//       // val result = first.await() + second.await() + third.await()
//
//
//       // println(first)
//    }
    val source = listOf(1, 2, 3).toObservable()
    source
        .subscribeOn(Schedulers.io())
        .map { it }
        .subscribeBy {
            println(it)
            async { thirdNumber()}
            async { secondNumber() }
            async { firstNumber() }
            println("RX "+Thread.currentThread().name.toString())
            Thread.sleep(500)

        }

   // println(time) //prints 7 seconds
}

suspend fun firstNumber(): Int =withContext(Dispatchers.IO){
    println("threadname: " + Thread.currentThread().name.toString())
    delay(3_000) // 3 seconds delay
    return@withContext 5
}

suspend fun secondNumber(): Int {
    println("threadname: " + Thread.currentThread().name.toString())
    delay(5_000) // 5 seconds delay
    return 8
}

suspend fun thirdNumber(): Int {
    println("threadname: " + Thread.currentThread().name.toString())
    delay(7_000) // 7 seconds delay
    return 10
}