package advent.of.code.utils

import advent.of.code.utils.Log.Failure
import advent.of.code.utils.Log.Success
import kotlin.reflect.KFunction1

public interface InspectorScope {

    public fun log(function: KFunction1<String, Any>, param: String)
}


internal interface Inspector {
    fun inspect(block: InspectorScope.() -> Unit)
}

internal class InspectorImpl : Inspector {

    private val logs = mutableListOf<Log>()

    override fun inspect(block: InspectorScope.() -> Unit) {
        InspectorScopeImpl(logs::add).apply(block)
        inspect(logs)
    }

    private fun inspect(logs: List<Log>) {
        val length = logs.maxOf { it.length + it.prefix.length + 2 }

        println("Results {")
        for (log in logs) {
            when (log) {
                is Success -> inspect(log, length)
                is Failure -> inspect(log, length)
            }
        }
        println("}")
    }

    private fun inspect(success: Success, length: Int) {
        val format = String.format(
            "\t=> %-${length}s | %s",
            "${success.prefix}: ${success.result}", success.suffix
        )
        println(format)
    }

    private fun inspect(failure: Failure, length: Int) {
        val format = String.format(
                "\t=> %-${length}s | %s",
                "${failure.prefix}: ${failure.result}", failure.suffix
        )
        println(format)

        val needs = failure.exception.stackTrace.indexOfFirst {
            !it.className.startsWith("advent.of.code")
        }
        failure.exception.stackTrace = failure.exception.stackTrace.sliceArray(0..needs)
        failure.exception.printStackTrace()
    }
}

internal class InspectorScopeImpl(
        private val commit: (Log) -> Unit
) : InspectorScope {
    override fun log(function: KFunction1<String, Any>, param: String) {
        runCatching { function(param) }
            .onSuccess { commit(Success("$it", function.name)) }
            .onFailure { commit(Failure(it, function.name)) }
    }
}

internal sealed interface Log {
    val prefix: String
    val suffix: String
    val length: Int

    data class Success(
        val result: String,
        override val prefix: String,
        override val suffix: String = "Success",
    ) : Log {
        override val length get() = result.length
    }

    data class Failure(
        val exception: Throwable,
        override val prefix: String,
        override val suffix: String = "Failure",
    ) : Log {
        val result get() = ""
        override val length get() = result.length
    }
}
