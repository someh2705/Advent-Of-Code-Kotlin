package advent.of.code.utils

import kotlin.reflect.KFunction1

public interface BenchmarkScope {

    public fun create(function: KFunction1<String, Any>, param: String)
}

internal interface Benchmark {

    fun benchmark(block: BenchmarkScope.() -> Unit)
}
