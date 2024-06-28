package student;

/**
 * Card Class representing a Card with a rank and suit.
 */
public class Card {
    /**
     *  integer reprsenting card rank.
    */
    private int rankTrue = 1;

    /**
     * integer representing suit rank.
     */
    private int suitTrue = 1;

    /**
     * @param rank -- integer representing the rank of the card.
     * @param suit -- integer representing the suit of the card.
     */
    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13 || suit < 1 || suit > 4) {
            System.out.println("Invalid Card");
        } else {
            rankTrue = rank;
            suitTrue = suit;
        }
    }

    /**
     * Gives Rank as a Number.
     * @return -- integer of the rank.
     */
    public int getRankNum() {
        return rankTrue;
    }

    /**
     * Gives Rank Name.
     * @return -- String representation of the rank.
     */
    public String getRankName() {
        String output;

        if (rankTrue == 1) {
            output = "Ace";
        } else if (rankTrue == 2) {
            output = "Two";
        } else if (rankTrue == 3) {
            output = "Three";
        } else if (rankTrue == 4) {
            output = "Four";
        } else if (rankTrue == 5) {
            output = "Five";
        } else if (rankTrue == 6) {
            output = "Six";
        } else if (rankTrue == 7) {
            output = "Seven";
        } else if (rankTrue == 8) {
            output = "Eight";
        } else if (rankTrue == 9) {
            output = "Nine";
        } else if (rankTrue == 10) {
            output = "Ten";
        } else if (rankTrue == 11) {
            output = "Jack";
        } else if (rankTrue == 12) {
            output = "Queen";
        } else if (rankTrue == 13) {
            output = "King";
        } else {
            output = "Ace";
        }
        return output;
    }

    /**
     * Gives Suit Name.
     * @return -- String representation of the Suit.
     */
    public String getSuitName() {
        String output;

        if (suitTrue == 1) {
            output = "Spades";
        } else if (suitTrue == 2) {
            output = "Hearts";
        } else if (suitTrue == 3) {
            output = "Clubs";
        } else if (suitTrue == 4) {
            output = "Diamonds";
        } else {
            output = "Spades";
        }

        return output;

    }

    @Override
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card other = (Card) obj;

            return other.getRankNum() == this.getRankNum() && other.getSuitName() == this.getSuitName();
        } else {
            return false;
        }
    }
}
