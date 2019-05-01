fun processGame(game: Array<Int>): Int {
    var gameIndex = 0

    return (0..9).map {
        val score1 = game[gameIndex++]

        val score2 = if (score1 != 10) game[gameIndex++] else 0

        val bonus = when {
            // A strike is scored.
            (score1 == 10) -> game[gameIndex] + game[gameIndex + 1]

            // A spare is scored.
            (score1 + score2 == 10) -> game[gameIndex]

            // No bonus score :(
            else -> 0
        }

        score1 + score2 + bonus
    }.sum()
}

