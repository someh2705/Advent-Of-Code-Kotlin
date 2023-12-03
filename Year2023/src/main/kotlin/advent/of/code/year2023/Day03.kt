package advent.of.code.year2023

object Day03 : Problem(Day03::class) {

    private data class Part(val value: Int, val outline: List<Int>)

    fun partOne(path: String) = multiLine(path) { input ->
        val length = input.indexOf('\n') + 1

        Regex("\\d+")
            .findAll(input)
            .map { createPart(it, length) }
            .filter { validPart(it, input) }
            .sumOf { it.value }
    }

    fun partTwo(path: String) = multiLine(path) { input ->
        val length = input.indexOf('\n') + 1

        val parts = Regex("\\d+")
            .findAll(input)
            .map { createPart(it, length) }
            .toList()

        val symbols = Regex("[*]")
            .findAll(input)
            .map { it.range.first }

        symbols.sumOf { symbol ->
            val find = parts.filter { it.outline.contains(symbol) }

            if (find.size == 2) {
                find.first().value * find.last().value
            } else 0
        }
    }

    private fun createPart(part: MatchResult, length: Int): Part {

        val range = part.range
        val outline =
            ((range.first - length - 1)..(range.last - length + 1)).toList() +
            ((range.first - 1)..(range.last + 1)).toList() +
            ((range.first + length - 1)..(range.last + length + 1)).toList()

        return Part(part.value.toInt(), outline)
    }

    private fun validPart(part: Part, input: String): Boolean {

        return part
                .outline
                .asSequence()
                .map { input.getOrNull(it) }
                .filterNotNull()
                .filter { it !in listOf('.', '\n') }
                .any { !it.isDigit() }
    }
}