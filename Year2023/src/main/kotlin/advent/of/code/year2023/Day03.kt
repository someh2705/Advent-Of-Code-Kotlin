package advent.of.code.year2023

object Day03 : Problem(Day03::class) {

    fun partOne(path: String) = multiLine(path) { input ->
        val length = input.indexOf('\n') + 1

        Regex("\\d+")
            .findAll(input)
            .filter { validPart(input, it, length) }
            .sumOf { it.value.toInt() }
    }

    private fun validPart(input: String, part: MatchResult, length: Int): Boolean {
        val range = part.range
        val outline =
            ((range.first - length - 1)..(range.last - length + 1)).toList() +
            ((range.first - 1)..(range.last + 1)).toList() +
            ((range.first + length - 1)..(range.last + length + 1)).toList()

        return outline
                .asSequence()
                .map { input.getOrNull(it) }
                .filterNotNull()
                .filter { it !in listOf('.', '\n') }
                .any { !it.isDigit() }
    }
}