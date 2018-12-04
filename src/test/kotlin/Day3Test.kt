import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day3Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day3.txt")
        }
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(4, Day3.part1("""
            #1 @ 1,3: 4x4
            #2 @ 3,1: 4x4
            #3 @ 5,5: 2x2
        """.trimIndent()))
    }

    @Test
    fun `part 1`() {
        assertEquals(104439, Day3.part1(INPUT))
    }
}