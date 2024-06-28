package student;

public class Tournament {

    /**
     * Calculates the win rate of player1 playing nTrials games.
     * @param player1 -- an AI representing a strategy for choosing cards. (goes first).
     * @param player2 -- an AI representing a strategy for choosing cards.
     * @param nTrials -- an integer representing the number of games to be played.
     */
    public static void winRate(AI player1, AI player2, int nTrials) {
        double p1Wins = 0;

        for (int i = 0; i < nTrials; ++i) {
            UnoWarMatch match = new UnoWarMatch(player1, player2);
            boolean winner = match.playGame();
            if (winner) {
                p1Wins += 1.0;
            }
        }

        double winPercentage = p1Wins / nTrials;

        System.out.println(player1 + " vs. " + player2 + " winRate: " + winPercentage);
    }

    /**
     * Runs various games between different AIs.
     * @param args
     */
    public static void main(String[] args) {
        AI randomAI = new AI();
        AI smallestAI = new SmallestCardAI();
        AI biggestAI = new BiggestCardAI();
        int nTrials = 1000;

        // Random vs. Random
        winRate(randomAI, randomAI, nTrials);
        // Random vs. Smallest
        winRate(randomAI, smallestAI, nTrials);
        // Random vs. Biggest
        winRate(randomAI, biggestAI, nTrials);

        // Smallest vs. Random
        winRate(smallestAI, randomAI, nTrials);
        // Smallest vs. Smallest
        winRate(smallestAI, smallestAI, nTrials);
        // Smallest vs. Biggest
        winRate(smallestAI, biggestAI, nTrials);
        // Biggest vs. Random
        winRate(biggestAI, randomAI, nTrials);
        // Biggest vs Smallest
        winRate(biggestAI, smallestAI, nTrials);
        // Biggest vs Biggest
        winRate(biggestAI, biggestAI, nTrials);
    }
}
