package advent.of.code.utils

import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.io.path.useLines

private const val Resources = "src/main/resources"

internal fun <T> provideSingleLine(path: String, block: (Sequence<String>) -> T): T {
    return provideInputsPerLine(path, block)
}

internal fun <T> provideMultiLine(path: String, block: (String) -> T): T {
    return provideInputsEveryLine(path, block)
}

internal fun <T> provideInputsPerLine(path: String, block: (Sequence<String>) -> T): T {
    return Path("$Resources/$path").useLines(block = block)
}

internal fun <T> provideInputsEveryLine(path: String, block: (String) -> T): T {
    return block(Path("$Resources/$path").readText())
}
