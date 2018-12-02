import utils.splitWhitespace

object Day2 {

    fun part1(input: String): Int {
        return input.splitWhitespace().asSequence()
                .fold(0 to 0) { (doubles, triples), string ->
                    val (foundDouble, foundTriplet) = string.asSequence()
                            .distinct()
                            .fold(0 to 0) { (foundDouble, foundTriplet), char ->
                                when (string.count { it == char }) {
                                    2 -> 1 to foundTriplet
                                    3 -> foundDouble to 1
                                    else -> foundDouble to foundTriplet
                                }
                            }

                    doubles + foundDouble to triples + foundTriplet
                }.product()
    }

    private fun Pair<Int, Int>.product(): Int = first * second

    fun part2(input: String): Int {
        TODO()
    }
}
