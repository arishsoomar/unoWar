package student;

/**
 *  CardPile Class representing a CardPile with a topCard and an integer
 * representing the size of the pile.
 */
public class CardPile {
    /**
     * Card representing top Card of the pile.
     */
    private Card realTopCard;
    /**
     * integer representing size of the card pile.
     */
    private int pileSize = 1;

    /**
     * Creates a Pile with an initial topCard.
     * @param topCard -- a Card representing the topCard.
     */
    public CardPile(Card topCard) {
        realTopCard = topCard;
    }

    /**
     * Checks if a given Card is valid according to the cardPile and rules.
     * @param card -- Card that needs to be checked to ensure validity.
     * @return -- true if card is valid else false.
     */
    public boolean canPlay(Card card) {
        if (card == null
        ||
        !(card.getRankNum() >= realTopCard.getRankNum()
        ||
        card.getSuitName().equals(realTopCard.getSuitName()))) {
            return false;
        }
        return true;
    }

    /**
     * If player plays a card that is valid we update the cardPile's topCard and the size of the pile.
     * @param card -- a Card the player wants to play.
     */
    public void play(Card card) {
        if (this.canPlay(card)) {
            realTopCard = card;
            pileSize++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    /**
     * Gives the # of cards in the pile.
     * @return -- an integer representing the size of the pile.
     */
    public int getNumCards() {
        return pileSize;
    }

    /**
     * Gives top card on the pile.
     * @return -- the top Card of the Pile.
     */
    public Card getTopCard() {
        return realTopCard;
    }
}
