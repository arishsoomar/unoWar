package student;

import java.util.Random;

/**
 * A Deck class representing a Deck of 52 cards.
 */
public class Deck {
    /**
     * Intilization of the Card Array representing a deck of 52 cards.
     */
    private Card[] deck;
    /**
     * integer tracking the index of the next card.
     */
    private int nextCardIdx;
    /**
     * new instance of Random.
     */
    private Random random;


    /** Creates a deck of 52 Cards.
     * No parameters.
     */
    public Deck() {
        deck = new Card[52];
        int rank;
        int suit;
        int idx = 0;

        for (suit = 1; suit <= 4; ++suit) {
            for (rank = 1; rank <= 13; ++rank) {
                deck[idx] = new Card(rank, suit);
                idx += 1;
            }
        }
        shuffle();
    }

    /**
     * No parameters.
     */
    public void shuffle() {
        random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        nextCardIdx = 0;
    }

    /**
     * @return a Card.
     */
    public Card draw() {
        if (nextCardIdx == deck.length) {
            shuffle();
        }
        return deck[nextCardIdx++];
    }

    /**
     * @param idx -- an integer representing the index of the card you want to retrieve.
     * @return -- a Card according to the index.
     */
    public Card getCard(int idx) {
        return deck[idx];
    }

    /** Checks the number of cards remaining in the deck.
     * @return -- an integer representing # cards remaining.
     */
    public int cardsRemaining() {
        return 52 - nextCardIdx;
    }

    /**
     * Checks to see if the deck is empty.
     * @return -- a boolean representing if the deck is empty.
     */
    public boolean isEmpty() {
        if (nextCardIdx == 52) {
            return true;
        } else {
            return false;
        }
    }

}
