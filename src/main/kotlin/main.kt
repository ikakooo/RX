@file:Suppress("FLOAT_LITERAL_CONFORMS_INFINITY")

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.util.HalfSerializer.onNext
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlin.concurrent.thread


val source2: Observable<Number> = listOf(1, 2,6666666,7777,4,44555,7564546500000000000000000000000000000000000.6).toObservable()
val source = listOf("A", "B", "C", "B", "k", "b").toObservable()
const val NUMBERED = 3454354354353453458725737405879562484567854764956843654665765757565768768768679867976957509809808509766757564546565465465443574359357987058927273295723573857235985732057238574827487238742873428374823748237423874238472387423842347239000000000000000000000000000000000000000004777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777547654896.5
const val IKAKOO = 32947872394947642374472384762478236742368467326232472346.0
fun main(args: Array<String>) {
    source.map { it == "B" }
        .subscribeBy(
            onNext = { println(it) }
        )
    source2
       // .subscribeOn(Schedulers.io())
        .map { it.toDouble() * 7.toLong() }
       //.filter { it >= 1 }
        .subscribeBy {
            println(it)
             println(Thread.currentThread().name.toString())
            Thread.sleep(1000)

        }
//    source2.map { "->>> ".repeat(it) }
//        .filter { it.length <= 25 }
//        .subscribeBy { println(it) }
    println(Thread.currentThread().name.toString())
    val stringgg = NUMBERED.toString()
println(stringgg+"  " + IKAKOO.toString())
    exampleOf("hjfsdhf dsfdf") {
        val popular: Observable<String> = Observable.just("fdggdf")
        val observable = Observable.just("dffd", "dfdsf", "dfsdf", "fdsdf", "dsfd")
        val observable2 = Observable.just(listOf("dffd", "dfdsf", "dfsdf", "fdsdf", "dsfd"))
        val observable3 = Observable.fromIterable(listOf("dffd", "dfdsf", "dfsdf", "fdsdf", "dsfd"))
        val observable4 = listOf("dffd", "dfdsf", "dfsdf", "fdsdf", "dsfd").toObservable()
        observable3
            .subscribeOn(Schedulers.io())
            .map { "->>>/ ".repeat(3) }
            .subscribeBy(
                onNext = { println(it) }
            )
    }

}
