package advent.of.code.year2023

val letters = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

fun letterToDigit(letter: String): Int {
    return when (letter) {
        in letters -> letters.indexOf(letter)
        else -> letter.toInt()
    }
}