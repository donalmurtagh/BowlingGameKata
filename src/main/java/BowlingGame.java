import java.util.List;

import static java.lang.String.format;

public class BowlingGame {

    public int processGame(List<Integer> game) {

        int ballIndex = 0, totalScore = 0;

        for (int frame = 0; frame < 10; frame++) {
            int firstBallScore = game.get(ballIndex);

            if (firstBallScore == 10) {
                totalScore += 10 + game.get(ballIndex + 1) + game.get(ballIndex + 2);
                ballIndex++;

            } else if (firstBallScore + game.get(ballIndex + 1) == 10) {
                totalScore += 10 + game.get(ballIndex + 2);
                ballIndex += 2;

            } else {
                totalScore += firstBallScore + game.get(ballIndex + 1);
                ballIndex += 2;
            }

            System.out.println(format("Cumulative score for frame %d: %d", frame + 1, totalScore));
        }
        return totalScore;
    }
}
