

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

object test{
        val tag = "TestCpuSpeed"
        fun cpu(){
            var counter = 0
            val numberOfThreads = 1_000_000
            val time = measureTimeMillis {
                for (i in 1..numberOfThreads) {
                    thread() {
                        counter += 1
                    }
                }
            }
            println("Created ${numberOfThreads} threads in ${time}ms.")

        }
    suspend fun cpuTestCoroutines()= coroutineScope{
        var counter = 0
        val numberOfCoroutines = 1_000_000
        val time = measureTimeMillis {
            for (i in 1..numberOfCoroutines) {
                launch { counter += 1 }
            }
        }
        println("Created ${numberOfCoroutines} OfCoroutines $counter in ${time}ms.")
    }
    }
