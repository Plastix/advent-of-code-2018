import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day5Test {

    companion object {
        private const val SAMPLE_INPUT = "dabAcCaCBAcCcaDA"
        private val INPUT by lazy {
            getResourceAsString("day5.txt")
        }
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(10, Day5.part1(SAMPLE_INPUT))
    }

    @Test
    fun `part 1`() {
        assertEquals(10888, Day5.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(4, Day5.part2(SAMPLE_INPUT))
    }

    @Test
    fun `part 2`() {
        assertEquals(6952, Day5.part2(INPUT))
    }
}