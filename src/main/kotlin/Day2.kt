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

    fun part2(input: String): String {
        val ids = input.splitWhitespace().asSequence()
        return ids.flatMap { one ->
            // Get all pairs of strings
            ids.map { two ->
                one to two
            }
        }.mapNotNull { (string1, string2) ->
            val (difference, index) = string1.countDifferentChars(string2)
            if (difference == 1) {
                string1.substring(0, index).plus(string1.substring(index + 1, string1.length))
            } else {
                null
            }
        }.distinct().joinToString(separator = "\n")
    }


    private fun String.countDifferentChars(other: String): Pair<Int, Int> {
        // Pair<Int, Int>: Number of different characters, index of first different character
        return foldIndexed(0 to -1) { index, acc, char ->
            if (other[index] != char) {
                acc.first + 1 to (if (acc.second == -1) index else acc.second)
            } else {
                acc
            }
        }
    }
}

