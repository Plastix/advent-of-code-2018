import utils.splitNewlines

object Day3 {

    fun part1(input: String): Int {
        val regex = Regex("(\\d+),(\\d+): (\\d+)x(\\d+)")
        return input.splitNewlines()
                .flatMap { line ->
                    val (x, y, h, w) = regex.findAll(line).toList().flatMap { match ->
                        match.groupValues.drop(1).map(String::toInt)
                    }

                    // Calculate list of cells (x, y)
                    (0..(h * w - 1)).map { index ->
                        x + (index / w) to y + (index % w)
                    }

                }.groupBy { it }.values
                .filter { it.size >= 2 }
                .count()
    }
}

