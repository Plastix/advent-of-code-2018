import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day4Test {

    companion object {
        private val SAMPLE_INPUT by lazy {
            getResourceAsString("day4-sample.txt")
        }
        private val INPUT by lazy {
            getResourceAsString("day4.txt")
        }
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(240, Day4.part1(SAMPLE_INPUT))
    }

    @Test
    fun `part 1`() {
        assertEquals(38813, Day4.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(4455, Day4.part2(SAMPLE_INPUT))
    }

    @Test
    fun `part 2`() {
        assertEquals(141071, Day4.part2(INPUT))
    }
}