package cardgame.models;


import cardgame.enums.Rank;
import cardgame.enums.Suit;

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
        return Integer.compare(otherCard.getCardPower(), this.getCardPower());
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rank.name(), this.suit.name());
    }
}
