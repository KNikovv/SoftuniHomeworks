package cardToString;

import cardToString.enums.Rank;
import cardToString.enums.Suit;

public class Card implements Comparable<Card> {

    private Rank rank;
    private Suit suit;
    private int cardPower;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.setCardPower();
    }

    public int getCardPower() {
        return this.cardPower;
    }

    private void setCardPower() {
        this.cardPower = this.rank.getRankPower() + this.suit.getRankSuit();
    }

    @Override
    public int compareTo(Card otherCard) {
        return Integer.compare(this.getCardPower(), otherCard.getCardPower());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank.name(),
                this.suit.name(),
                this.getCardPower());
    }
}
