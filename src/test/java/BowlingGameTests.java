import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BowlingGameTests {

    @Test
    public void Should_return_a_zero_score_When_all_gutter_balls() {
        // When
        List<Integer> game = Arrays.asList(
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
        );

        // Given
        Integer result = processGame(game);

        // Then
        assertThat(result, equalTo(0));
    }

    @Test
    public void Should_return_correct_score_When_9_pins_down_each_round() {
        List<Integer> game = Arrays.asList(
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
        );

        Integer result = processGame(game);
        assertThat(result, equalTo(90));
    }

    @Test
    public void Should_award_bonus_points_for_a_spare_When_scored_other_than_end_of_game() {
        List<Integer> game = Arrays.asList(
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
        );

        Integer result = processGame(game);
        assertThat(result, equalTo(20));
    }

    @Test
    public void Should_award_bonus_points_for_a_spare_When_scored_at_end_of_game() {
        List<Integer> game = Arrays.asList(
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
        );

        Integer result = processGame(game);
        assertThat(result, equalTo(15));
    }

    @Test
    public void Should_award_bonus_points_for_a_spare_When_scored_in_every_frame() {
        List<Integer> game = Arrays.asList(
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
        );

        Integer result = processGame(game);
        assertThat(result, equalTo(150));
    }

    @Test
    public void Should_award_bonus_points_for_a_strike_When_scored_other_than_end_of_game() {
        List<Integer> game = Arrays.asList(
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
        );

        Integer result = processGame(game);
        assertThat(result, equalTo(25));
    }

    @Test
    public void Should_award_bonus_points_for_a_strike_When_scored_at_end_of_game() {
        List<Integer> game = Arrays.asList(
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
        );

        Integer result = processGame(game);
        assertThat(result, equalTo(30));
    }

    @Test
    public void Should_award_bonus_points_When_a_perfect_game() {
        List<Integer> game = Arrays.asList(
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
        );

        Integer result = processGame(game);
        assertThat(result, equalTo(300));
    }


    @Test
    public void Should_award_bonus_points_When_scored_both_spares_and_strikes() {
        List<Integer> game = Arrays.asList(
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
        );

        Integer result = processGame(game);
        assertThat(result, equalTo(280));
    }

    private Integer processGame(List<Integer> game) {
        return new BowlingGame().processGame(game);
    }
}
