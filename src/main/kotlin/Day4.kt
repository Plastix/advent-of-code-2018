import utils.splitNewlines

object Day4 {

    private val guardId = Regex("#(\\d+)")
    private val minute = Regex(":(\\d+)")

    fun part1(input: String): Int = input.splitNewlines().asSequence()
            .guardsBySleepingMinutes()
            .maxBy { it.second.size }
            ?.let { guard ->
                val mostSleptMinute = guard.second.maxBy { num -> guard.second.count { it == num } }!!
                guard.first * mostSleptMinute
            } ?: 0

    private fun Sequence<String>.guardsBySleepingMinutes(): List<Pair<Int, List<Int>>> =
            sorted()
                    // (GuardId, [time1, time2, time1, time2])
                    .fold(mutableListOf<Pair<Int, MutableList<Int>>>()) { acc, line ->
                        if (line.contains("Guard")) {
                            val guardId = guardId.find(line)?.value?.drop(1)?.toInt() ?: -1
                            acc.add(guardId to mutableListOf())
                        } else {
                            val minute = minute.find(line)?.value?.drop(1)?.toInt() ?: 0
                            acc.last().second.add(minute)
                        }
                        acc

                    }
                    .groupBy { it.first }
                    .map {
                        val sleepingMinutes = it.value
                                .map { it.second.windowed(2, step = 2) }.flatten()
                                .map { it[0] until it[1] }.flatten()
                        it.key to sleepingMinutes
                    }

    fun part2(input: String): Int = input.splitNewlines().asSequence()
            .guardsBySleepingMinutes()
            .map { it.first to it.second.groupBy { it }.maxBy { it.value.size } }
            .maxBy { it.second?.value?.size ?: 0 }
            ?.let { it.first * it.second?.key!! } ?: 0

}

