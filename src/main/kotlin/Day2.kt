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
            val (differsByOne, index) = string1.differsByOne(string2)
            if (differsByOne) {
                string1.substring(0, index).plus(string1.substring(index + 1, string1.length))
            } else {
                null
            }
        }.distinct().joinToString(separator = "\n")
    }


    private fun String.differsByOne(other: String): Pair<Boolean, Int> {
        var differs = 0
        var differsIndex = -1
        forEachIndexed { index, c ->
            if (other[index] != c) {
                differs++
                differsIndex = index
            }
        }

        return (differs == 1) to differsIndex
    }
}

