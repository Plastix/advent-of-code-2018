import utils.splitWhitespace

object Day2 {

    private const val alphabet = "abcdefghijklmnopqrstuvwxyz"

    fun part1(input: String): Int {
        return input.splitWhitespace()
                .fold(0 to 0) { (doubles, triples), string ->
                    val (foundDouble, foundTriplet) = alphabet.toList()
                            .fold(false to false) { (foundDouble, foundTriplet), char ->
                                when (string.count { it == char }) {
                                    2 -> true to foundTriplet
                                    3 -> foundDouble to true
                                    else -> foundDouble to foundTriplet
                                }
                            }

                    doubles + foundDouble.toInt() to triples + foundTriplet.toInt()
                }.product()
    }

    private fun Pair<Int, Int>.product(): Int = first * second

    private fun Boolean.toInt() = if (this) 1 else 0


    fun part2(input: String): Int {
        TODO()
    }
}
