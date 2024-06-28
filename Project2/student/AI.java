package student;
public class AI {
    /**
     * This function gets the first card that is valid according to the card
     * pile. If there is no valid card then the method returns null and the
     * other player wins the round.
     *
     * @param hand an instance of Hand representing a player's hand of cards.
     * @param cardPile an instance of CardPile representing the card pile the
     * round is being played with.
     * @return the first card in the hand that is valid according to the game rules
     * if none of the cards are valid then it returns null.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i < hand.getSize(); ++i) {
            if (cardPile.canPlay(hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    /**
     * Overides the toString method.
     * @return -- a String.
     */
    @Override
    public String toString() {
        return "Random Card AI";
    }
}
