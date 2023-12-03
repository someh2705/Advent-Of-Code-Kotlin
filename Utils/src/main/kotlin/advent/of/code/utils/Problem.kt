package advent.of.code.utils

@Suppress("ClassName")
public abstract class _Problem(private val resource: String) {

    protected fun <T> singleLine(path: String, block: (inputs: Sequence<String>) -> T): T {
        return provideSingleLine("$resource/$path", block)
    }

    protected fun <T> multiLine(path: String, block: (input: String) -> T) :T {
        return provideMultiLine("$resource/$path", block)
    }
}
