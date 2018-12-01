import utils.splitWhitespace

object Day1 {

    fun part1(input: String): Int {
        return input
                .intList()
                .sum()
    }

    private fun String.intList(): List<Int> = splitWhitespace()
            .map { string -> string.toInt() }


    fun part2(input: String): Int {
        val list = input.intList()
        var sum = 0
        val seen = mutableSetOf(sum)

        while (true) {
            list.forEach { number ->
                sum += number
                if (sum in seen)
                    return sum
                else
                    seen.add(sum)
            }
        }
    }
}
