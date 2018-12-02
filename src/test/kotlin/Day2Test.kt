import junit.framework.TestCase.assertEquals
import org.junit.Ignore
import org.junit.Test
import utils.getResourceAsString

class Day2Test {

    @Test
    fun `part 1 samples`() {
        assertEquals(12, Day2.part1("abcdef\n" +
                "bababc\n" +
                "abbcde\n" +
                "abcccd\n" +
                "aabcdd\n" +
                "abcdee\n" +
                "ababab"))
    }

    @Test
    fun `part 1`() {
        assertEquals(7533, Day2.part1(getResourceAsString("day2.txt")))
    }

    @Ignore
    @Test
    fun `part 2 samples`() {
        assertEquals(0, Day1.part2("+1 -1"))
        assertEquals(10, Day1.part2("+3 +3 +4 -2 -4"))
        assertEquals(5, Day1.part2("-6 +3 +8 +5 -6"))
        assertEquals(14, Day1.part2("+7 +7 -2 -7 -4"))
    }

    @Ignore
    @Test
    fun `part 2`() {
        assertEquals(56360, Day1.part2(getResourceAsString("day1.txt")))
    }
}