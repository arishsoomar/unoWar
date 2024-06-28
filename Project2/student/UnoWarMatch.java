package student;

/**
 * A class representing an UnoWarMatch between 2 AIs.
 */
public class UnoWarMatch {
    /**
     * an AI representing player 1.
     */
    private AI realAI1;
    /**
     * an AI representing player 2.
     */
    private AI realAI2;

    /**
     * Simulates an UnoWarMatch between 2 AIs.
     *
     * @param ai1
     * @param ai2
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        realAI1 = ai1;
        realAI2 = ai2;
    }

    /**
     * Plays a game of UnoWar between 2 players.
     *
     * @return -- a boolean represenenting the winner (true = p1) (false = p2).
     */
    public boolean playGame() {
        Deck deck = new Deck();
        Hand hand1 = new Hand(deck, 5);
        Hand hand2 = new Hand(deck, 5);

        int p1Points = 0;
        int p2Points = 0;
        int currentRound = 1;
        int roundWinner = -1;

        while (p1Points != 10 && p2Points != 10) {
            if (currentRound != 1) {
                if (roundWinner == 1) {
                    roundWinner = playRound(deck, hand1, hand2, true, false, currentRound);
                    if (roundWinner == 1) {
                        p1Points++;
                    } else {
                        p2Points++;
                    }
                    currentRound++;
                } else {
                    roundWinner = playRound(deck, hand1, hand2, false, true, currentRound);
                    if (roundWinner == 1) {
                        p1Points++;
                    } else {
                        p2Points++;
                    }
                    currentRound++;
                }
            } else {
                roundWinner = playRound(deck, hand1, hand2, true, false, currentRound);
                if (roundWinner == 1) {
                    p1Points++;
                } else {
                    p2Points++;
                }
                currentRound++;
            }
        }

        if (p1Points == 10) {
            return true;
        }
        return false;

    }

    private int playRound(Deck deck, Hand hand1, Hand hand2,
            boolean player1Turn, boolean player2Turn, int currentRound) {

        CardPile cardPile = new CardPile(deck.draw());
        boolean p1Turn = player1Turn;
        boolean p2Turn = player2Turn;
        Card p1Play = realAI1.getPlay(hand1, cardPile);
        Card p2Play = realAI2.getPlay(hand2, cardPile);

        if (deck.isEmpty()) {
            deck = new Deck();
        }

        while (p1Play != null && p2Play != null) {
            if (p1Turn) {
                cardPile.play(p1Play);
                hand1.remove(p1Play);
                if (deck.isEmpty()) {
                    deck = new Deck();
                }
                p2Play = realAI2.getPlay(hand2, cardPile);
                p1Turn = false;
                p2Turn = true;
            } else if (p2Turn) {
                cardPile.play(p2Play);
                hand2.remove(p2Play);
                if (deck.isEmpty()) {
                    deck = new Deck();
                }
                p1Play = realAI1.getPlay(hand1, cardPile);
                p2Turn = false;
                p1Turn = true;
            }
        }
        if (p1Play == null) {
            return 2;
        }
        return 1;
    }
    /**
     * This method plays a game between the two AIs nTrials times and calculates the win rate.
     * @param nTrials -- int representing the number of games played to calculate the win rate.
     * @return -- a double representing the win rate.
     */
    public double winRate(int nTrials) {
        double p1Wins = 0;

        for (int i = 0; i < nTrials; ++i) {
            UnoWarMatch match = new UnoWarMatch(realAI1, realAI2);
            boolean winner = match.playGame();
            if (winner) {
                p1Wins += 1.0;
            }
        }

        double winPercentage = p1Wins / nTrials;

        return winPercentage;
    }
}
