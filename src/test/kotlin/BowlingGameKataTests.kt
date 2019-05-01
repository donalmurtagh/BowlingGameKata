import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test


class BowlingGameKataTests {

    @Test
    fun `testSomething - Should return string wrapped with XX`() {
        // When
        val valueToTest = "SomethingToTest"
        val expectedResult = "XX-$valueToTest-YY"

        // Given
        val result = BowlingGameKata().testSomething(valueToTest)

        // Then
        assertThat(result, equalTo(expectedResult))
    }

}