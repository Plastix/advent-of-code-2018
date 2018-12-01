import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day1Test {

    @Test
    fun `part 1 samples`() {
        assertEquals(3, Day1.part1("+1 +1 +1"))
        assertEquals(0, Day1.part1("+1 +1 -2"))
        assertEquals(-6, Day1.part1("-1 -2 -3"))
    }

    @Test
    fun `part 1`() {
        assertEquals(411, Day1.part1(getResourceAsString("day1.txt")))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(0, Day1.part2("+1 -1"))
        assertEquals(10, Day1.part2("+3 +3 +4 -2 -4"))
        assertEquals(5, Day1.part2("-6 +3 +8 +5 -6"))
        assertEquals(14, Day1.part2("+7 +7 -2 -7 -4"))
    }

    @Test
    fun `part 2`() {
        assertEquals(56360, Day1.part2(getResourceAsString("day1.txt")))
    }
}