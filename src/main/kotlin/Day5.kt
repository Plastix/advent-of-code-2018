import java.util.*

object Day5 {

    fun part1(input: String): Int = input.asSequence()
            .react()
            .size

    private fun Sequence<Char>.react(): Stack<Char> =
            fold(Stack()) { stack, char ->
                if (stack.isNotEmpty() && stack.peek().opposites(char)) {
                    stack.pop()
                } else {
                    stack.push(char)
                }
                stack
            }

    private fun Char.opposites(other: Char): Boolean = equals(other, ignoreCase = true) &&
            ((isUpperCase() && other.isLowerCase()) || (isLowerCase() && other.isUpperCase()))

    fun part2(input: String): Int = input.asSequence()
            .distinctBy { it.toLowerCase() }
            .map { char ->
                input.replace(char.toString(), "", ignoreCase = true).asSequence()
                        .react().size
            }.min() ?: 0

}

