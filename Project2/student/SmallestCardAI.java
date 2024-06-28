package student;

public class SmallestCardAI extends AI {
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card[] validCards = new Card[hand.getSize()];
        int numValidCards = 0;

        for (int i = 0; i < validCards.length; ++i) {
            if (cardPile.canPlay(hand.get(i))) {
                validCards[numValidCards++] = hand.get(i);
            }
        }

        if (numValidCards == 0) {
            return null;
        }
        if (numValidCards == 1) {
            return validCards[0];
        }

        int tempRank = 100;
        Card smallestCard = null;

        for (int i = 0; i < numValidCards; ++i) {
            int currentRank = validCards[i].getRankNum();
            if (currentRank < tempRank) {
                tempRank = currentRank;
                smallestCard = validCards[i];
            }
        }
        return smallestCard;
    }

    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}
