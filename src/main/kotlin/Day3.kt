import utils.splitNewlines

// Cell Format: (id, (x, y))
typealias Cell = Pair<Int, Pair<Int, Int>>

object Day3 {

    private val regex = Regex("(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)")

    fun part1(input: String): Int =
            input.splitNewlines().asSequence()
                    .getAllClaimedCells()
                    .groupBy { it.second }
                    .filter { it.value.size > 1 }
                    .count()

    private fun parseInputLine(input: String): List<Int> =
            regex.findAll(input).toList().flatMap { match ->
                match.groupValues.drop(1).map(String::toInt)
            }

    private fun Sequence<String>.getAllClaimedCells(): Sequence<Cell> =
            flatMap { line ->
                val (id, x, y, width, height) = parseInputLine(line)

                (0..(height * width - 1)).asSequence().map { index ->
                    Cell(id, x + (index % width) to y + (index / width))
                }
            }

    fun part2(input: String): Int {
        val claimedCells = input.splitNewlines().asSequence()
                .getAllClaimedCells()

        val overlappingIds = claimedCells.groupBy { it.second }
                .filter { it.value.size > 1 }.values.flatten()
                .map { it.first }
                .toSet()

        return claimedCells.map { it.first }
                .first { it !in overlappingIds }
    }
}

