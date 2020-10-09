import javafx.application.Application.launch
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

 fun main() =runBlocking<Unit>{



  val ikako = async{ fetchDocs()}


}

suspend fun fetchDocs() {                             // Dispatchers.Main
    val result = get("https://developer.android.com") // Dispatchers.IO for `get`
    println(result)
    test.cpuTestCoroutines()// Dispatchers.Main
}

suspend fun get(url: String) = withContext(Dispatchers.IO) { return@withContext url +"  dsfdsfsdfsdf" }