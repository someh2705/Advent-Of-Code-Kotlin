package advent.of.code.utils

public object Debugger : Inspector, Benchmark {

    override fun inspect(block: InspectorScope.() -> Unit) {
        InspectorImpl().inspect(block)
    }

    override fun benchmark(block: BenchmarkScope.() -> Unit) {

    }
}