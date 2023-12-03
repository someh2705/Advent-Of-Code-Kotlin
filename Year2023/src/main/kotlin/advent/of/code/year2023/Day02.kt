package advent.of.code.year2023

object Day02 : Problem(Day02::class) {

    private val Red = Regex("\\d+(?= red)")
    private val Green = Regex("\\d+(?= green)")
    private val Blue = Regex("\\d+(?= blue)")

    private data class Game(val id: Int, val sets: List<GameSet>)
    private data class GameSet(val red: Int, val green: Int, val blue: Int)

    private fun inputToGame(input: String): Game {
        val (gameId, gameSets) = input.split(": ")

        val id = gameId.removePrefix("Game ").toInt()
        val sets = gameSets.split("; ").map { gameSet ->
            val red = countColor(gameSet, Red)
            val green = countColor(gameSet, Green)
            val blue = countColor(gameSet, Blue)

            GameSet(red, green, blue)
        }

        return Game(id, sets)
    }

    private fun countColor(gameSet: String, regex: Regex): Int {
        return regex.find(gameSet)?.value?.toInt() ?: 0
    }

    private fun validGame(game: Game): Boolean {
        return game.sets.all {
            it.red < 13 && it.green < 14 && it.blue < 15
        }
    }

    fun partOne(path: String) = solve(path) { inputs ->

        inputs
            .map(::inputToGame)
            .filter(::validGame)
            .sumOf { it.id }
    }
}