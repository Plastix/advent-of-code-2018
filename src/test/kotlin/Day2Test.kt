import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day2Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day2.txt")
        }
    }

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
        assertEquals(7533, Day2.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals("fgij", Day2.part2("""
            abcde
            fghij
            klmno
            pqrst
            fguij
            axcye
            wvxyz
        """.trimIndent()))
    }

    @Test
    fun `part 2`() {
        assertEquals("mphcuasvrnjzzkbgdtqeoylva", Day2.part2(INPUT))
    }
}