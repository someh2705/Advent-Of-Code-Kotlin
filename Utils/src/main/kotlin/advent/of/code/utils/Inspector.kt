package advent.of.code.utils

import kotlin.reflect.KFunction1
import kotlin.time.Duration
import kotlin.time.measureTimedValue

public interface InspectorScope {

    public fun inspect(function: KFunction1<String, Any>, param: String)
}


internal interface Inspector {
    fun solution(block: InspectorScope.() -> Unit)
}

internal class InspectorImpl : Inspector {

    private val logs = mutableListOf<Log>()

    override fun solution(block: InspectorScope.() -> Unit) {
        InspectorScopeImpl(logs::add).apply(block).inspect(logs)
    }
}

internal class InspectorScopeImpl(
    private val commit: (Log) -> Unit
) : InspectorScope {
    override fun inspect(function: KFunction1<String, Any>, param: String) {
        val measure = measureTimedValue {
            function(param)
        }

        commit(Log(measure.duration, function.name, "${measure.value}"))
    }

    internal fun inspect(logs: List<Log>) {
        val length = logs.maxOf { it.prefix.length + it.result.length + 2 }

        println("Results {")
        for ((measure, prefix, result) in logs) {
            val format = String.format(
                "\t=> %-${length}s | %2sms",
                "$prefix: $result", measure.inWholeMilliseconds
            )
            println(format)
        }
        println("}")
    }
}

internal data class Log(
    val measure: Duration,
    val prefix: String,
    val result: String,
)
