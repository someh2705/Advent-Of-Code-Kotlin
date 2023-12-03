package advent.of.code.utils

import kotlin.io.path.Path
import kotlin.io.path.useLines

private const val Resources = "src/main/resources"

internal fun <T> provide(path: String, block: (Sequence<String>) -> T): T {
    return provideInputsPerLine(path, block)
}

internal fun <T> provideInputsPerLine(path: String, block: (Sequence<String>) -> T): T {
    return Path("$Resources/$path").useLines(block = block)
}
