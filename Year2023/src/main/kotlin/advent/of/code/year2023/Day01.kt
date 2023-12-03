package advent.of.code.year2023

object Day01 : Problem(Day01::class) {

    fun partOne(path: String) = singleLine(path) { inputs ->
        val regex = Regex("\\d")
        inputs.sumOf { input ->
            val matches = regex.findAll(input).toList()
            val first = matches.first().value
            val last = matches.last().value

            "$first$last".toInt()
        }
    }


    /**
     * 만약 정규표현식을 [Lookahead Assertion]을 사용하지 않으면 nineight 문자의 경우 nine만 매칭됩니다.
     *
     * 다른 해결 방법으로 eight -> e8t, nine -> n9e 등으로 변경하여 [Day01.partOne]을 재사용할 수 있습니다.
     * 하지만 이 방법은 최소 9번의 루프가 필요하므로 사용하지 않았습니다.
     */
    fun partTwo(path: String) = singleLine(path) { inputs ->
        val letterRegex = letters.joinToString("|")
        val regex = Regex("(?=($letterRegex|\\d))")

        inputs.sumOf { input ->
            val matches = regex.findAll(input).toList()
            val (_, first) = matches.first().groupValues
            val (_, last) = matches.last().groupValues

            "${letterToDigit(first)}${letterToDigit(last)}".toInt()
        }
    }
}