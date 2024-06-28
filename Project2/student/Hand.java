package student;

/**
 * A Hand class representing a hand of cards a player can possess.
 */
public class Hand {
    /**
     * Card Array representing a hand.
     */
    private Card[] handOfCards;
    /**
     * a Deck representing a deck of 52 cards.
     */
    private Deck realDeck;

    /**
     * Creates a Hand taking in a deck and the length of the Card Array.
     * @param deck -- a Deck of Cards.
     * @param size -- an integer representing the length of the Card Array.
     */
    public Hand(Deck deck, int size) {
        handOfCards = new Card[size];
        realDeck = deck;
        for (int i = 0; i < size; ++i) {
            handOfCards[i] = realDeck.draw();
        }
    }

    /**
     * Get the length of the Card array (Hand).
     * @return -- integer representing the length of the hand.
     */
    public int getSize() {
        return handOfCards.length;
    }

    /**
     * Gives a card at a specific index of a Hand.
     * @param i -- an integer representing an index.
     * @return -- a Card at the specified index.
     */
    public Card get(int i) {
        if (this.getSize() <= i || i < 0) {
            System.out.println("Invalid hand index!");
            return handOfCards[0];
        }
        return handOfCards[i];
    }

    /**
     * Removes a card from the Hand that is calling the method.
     * @param card -- a Card representing a playing card.
     * @return -- true if the card was successfully removed, else false.
     */
    public boolean remove(Card card) {
        for (int i = 0; i < this.getSize(); ++i) {
            if (handOfCards[i] == card) {
                handOfCards[i] = realDeck.draw();
                return true;
            }
        }
        return false;
    }

}
