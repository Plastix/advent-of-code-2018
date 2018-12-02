import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day2Test {

    @Test
    fun `part 1 samples`() {
        assertEquals(12, Day2.part1("""
        abcdef
        bababc
        abbcde
        abcccd
        aabcdd
        abcdee
        ababab
        """.trimIndent()))
    }

    @Test
    fun `part 1`() {
        assertEquals(7533, Day2.part1(getResourceAsString("day2.txt")))
    }

    @Test
    fun `part 2 samples`() {
        TODO()
    }

    @Test
    fun `part 2`() {
        TODO()
    }
}