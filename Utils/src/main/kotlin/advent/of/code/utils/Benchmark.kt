package advent.of.code.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlin.reflect.KFunction1
import kotlin.time.Duration
import kotlin.time.measureTime

public interface BenchmarkScope {

    public fun create(function: KFunction1<String, Any>, param: String)
}

internal interface Benchmark {

    fun benchmark(block: BenchmarkScope.() -> Unit)
}

internal const val BatchSize = 100

internal class BenchmarkScopeImpl(val commit: (BenchmarkResult) -> Unit) : BenchmarkScope {

    override fun create(function: KFunction1<String, Any>, param: String) {
        runBlocking(Dispatchers.Default) {
            val processor = Runtime.getRuntime().availableProcessors()
            val results = (0..processor).flatMap {
                (0..BatchSize).map {
                    async { measureTime { function(param) } }
                }
            }.awaitAll().sorted()

            val mid = results[results.size / 2]
            val min = results.first()
            val max = results.last()
            commit(BenchmarkResult(function.name, mid, min, max))
        }
    }
}

internal class BenchmarkImpl : Benchmark {
    override fun benchmark(block: BenchmarkScope.() -> Unit) {
        BenchmarkScopeImpl {
            println(
            """
                Benchmark: ${it.prefix}    
                => Max Time: ${it.max}    
                => Min Time: ${it.min}    
                => Mid Time: ${it.mid}    
                    
            """.trimIndent())
        }.apply(block)
    }
}

internal data class BenchmarkResult(
    val prefix: String,
    val mid: Duration,
    val min: Duration,
    val max: Duration
)