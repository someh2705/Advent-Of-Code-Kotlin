package advent.of.code.utils

@Suppress("ClassName")
public abstract class _Problem(private val resource: String) {

    protected fun <T> solve(path: String, block: (Sequence<String>) -> T): T {
        return provide("$resource/$path", block)
    }
}
