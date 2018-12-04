import utils.splitNewlines

// Cell Format: (id, (x, y))
typealias Cell = Pair<Int, Pair<Int, Int>>

object Day3 {

    private val regex = Regex("(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)")

    fun part1(input: String): Int =
            input.splitNewlines().asSequence()
                    .getAllClaimedCells()
                    .groupBy { it.second }
                    .filter { it.value.size >= 2 }
                    .count()

    private fun parseInputLine(input: String): List<Int> =
            regex.findAll(input).toList().flatMap { match ->
                match.groupValues.drop(1).map(String::toInt)
            }

    private fun Sequence<String>.getAllClaimedCells(): Sequence<Cell> =
            flatMap { line ->
                val (id, x, y, h, w) = parseInputLine(line)

                // Calculate list of cells (x, y)
                (0..(h * w - 1)).asSequence().map { index ->
                    id to (x + (index / w) to y + (index % w))
                }
            }

    fun part2(input: String): Int {
        val claimedCells = input.splitNewlines().asSequence()
                .getAllClaimedCells()

        val allIds = claimedCells.map { it.first }
        val overlappingIds = claimedCells.groupBy { it.second }
                .filter { it.value.size >= 2 }.values.flatten()
                .map { it.first }
                .toSet()

        return allIds.first { it !in overlappingIds }
    }
}

