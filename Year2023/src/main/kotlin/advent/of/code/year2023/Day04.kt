package advent.of.code.year2023

object Day04 : Problem(Day04::class) {

    private data class Card(val set: Int, val wins: List<String>, val have: List<String>)

    fun partOne(path: String) = singleLine(path) { inputs ->

        inputs
            .parsing()
            .worthTotal()
    }

    fun partTwo(path: String) = singleLine(path) { inputs ->

        inputs
            .parsing()
            .scratchTotal()
    }

    private fun Sequence<String>.parsing(): Sequence<Card> =
        map { input ->
            val (set, numbers) = input.split(":")
            val (wins, have) = numbers.split("|")

            Card(
                set = set.drop(4).trimIndent().toInt(),
                wins = wins.split(" ").filter { it.isNotEmpty() },
                have = have.split(" ").filter { it.isNotEmpty() }
            )
        }

    private fun Sequence<Card>.worthTotal(): Int =
        sumOf { (_, wins, have) ->
            wins.fold(1) { acc, win ->
                if (win in have) acc * 2
                else acc
            } / 2
        }

    private fun Sequence<Card>.scratchTotal(): Int {
        val cards = toList()
        val scratchCards = IntArray(cards.size) { 1 }

        for ((set, wins, have) in cards) {
            val match = have.count { it in wins }

            repeat(match) {
                scratchCards[set + it] += scratchCards[set - 1]
            }
        }

        return scratchCards.sum()
    }
}