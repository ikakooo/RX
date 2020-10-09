import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    repeat(100000) {
        launch {
            delay(100)
            println("coroutine $it")
        }
    }
}