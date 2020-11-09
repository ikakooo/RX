import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    repeat(100000) {
        //delay(500)
        launch {
           // println("coroutine $it")
        }
    }
}