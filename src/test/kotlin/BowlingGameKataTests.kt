import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test


class BowlingGameKataTests {

    @Test
    fun `processGame - Should return a zero score - When all gutter balls`() {
        val game = arrayOf(
                0, 0, // Frame 1
                0, 0, // Frame 2
                0, 0, // Frame 3
                0, 0, // Frame 4
                0, 0, // Frame 5
                0, 0, // Frame 6
                0, 0, // Frame 7
                0, 0, // Frame 8
                0, 0, // Frame 9
                0, 0 // Frame 10
        )

        val result = processGame(game)
        assertThat(result, equalTo(0))
    }

    @Test
    fun `processGame - Should return correct score - When 9 pins down each round`() {
        val game = arrayOf(
                9, 0, // Frame 1
                9, 0, // Frame 2
                9, 0, // Frame 3
                9, 0, // Frame 4
                9, 0, // Frame 5
                9, 0, // Frame 6
                9, 0, // Frame 7
                9, 0, // Frame 8
                9, 0, // Frame 9
                9, 0 // Frame 10
        )

        val result = processGame(game)
        assertThat(result, equalTo(90))
    }

    @Test
    fun `processGame - Should award bonus points for a spare - When scored other than end of game`() {
        val game = arrayOf(
                5, 5, // Frame 1
                5, 0, // Frame 2
                0, 0, // Frame 3
                0, 0, // Frame 4
                0, 0, // Frame 5
                0, 0, // Frame 6
                0, 0, // Frame 7
                0, 0, // Frame 8
                0, 0, // Frame 9
                0, 0 // Frame 10
        )

        val result = processGame(game)
        assertThat(result, equalTo(20))
    }

    @Test
    fun `processGame - Should award bonus points for a spare - When scored at end of game`() {
        val game = arrayOf(
                0, 0, // Frame 1
                0, 0, // Frame 2
                0, 0, // Frame 3
                0, 0, // Frame 4
                0, 0, // Frame 5
                0, 0, // Frame 6
                0, 0, // Frame 7
                0, 0, // Frame 8
                0, 0, // Frame 9
                5, 5, 5 // Frame 10
        )

        val result = processGame(game)
        assertThat(result, equalTo(15))
    }

    @Test
    fun `processGame - Should award bonus points for a spare - When scored in every frame`() {
        val game = arrayOf(
                5, 5, // Frame 1
                5, 5, // Frame 2
                5, 5, // Frame 3
                5, 5, // Frame 4
                5, 5, // Frame 5
                5, 5, // Frame 6
                5, 5, // Frame 7
                5, 5, // Frame 8
                5, 5, // Frame 9
                5, 5, 5 // Frame 10
        )

        val result = processGame(game)
        assertThat(result, equalTo(150))
    }

    @Test
    fun `processGame - Should award bonus points for a strike - When scored other than end of game`() {
        val game = arrayOf(
                10, // Frame 1
                0, 5, // Frame 2
                5, 0, // Frame 3
                0, 0, // Frame 4
                0, 0, // Frame 5
                0, 0, // Frame 6
                0, 0, // Frame 7
                0, 0, // Frame 8
                0, 0, // Frame 9
                0, 0 // Frame 10
        )

        val result = processGame(game)
        assertThat(result, equalTo(25))
    }

    @Test
    fun `processGame - Should award bonus points for a strike - When scored at end of game`() {
        val game = arrayOf(
                0, 0, // Frame 1
                0, 0, // Frame 2
                0, 0, // Frame 3
                0, 0, // Frame 4
                0, 0, // Frame 5
                0, 0, // Frame 6
                0, 0, // Frame 7
                0, 0, // Frame 8
                0, 0, // Frame 9
                10, 10, 10 // Frame 10
        )

        val result = processGame(game)
        assertThat(result, equalTo(30))
    }

    @Test
    fun `processGame - Should award bonus points - When a perfect game`() {
        val game = arrayOf(
                10, // Frame 1
                10, // Frame 2
                10, // Frame 3
                10, // Frame 4
                10, // Frame 5
                10, // Frame 6
                10, // Frame 7
                10, // Frame 8
                10, // Frame 9
                10, 10, 10 // Frame 10
        )

        val result = processGame(game)
        assertThat(result, equalTo(300))
    }


    @Test
    fun `processGame - Should award bonus points - When scored both spares and strikes`() {
        val game = arrayOf(
                10, // Frame 1
                5, 5, // Frame 2
                10, // Frame 3
                10, // Frame 4
                10, // Frame 5
                10, // Frame 6
                10, // Frame 7
                10, // Frame 8
                10, // Frame 9
                10, 10, 10// Frame 10
        )

        val result = processGame(game)
        assertThat(result, equalTo(280))
    }

}