package cardgame.enums;

public enum  Suit {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int rankSuit;

    Suit(int power) {
        this.setRankSuit(power);
    }

    private void setRankSuit(int rankSuit) {
        this.rankSuit = rankSuit;
    }

    public int getRankSuit() {
        return this.rankSuit;
    }
}
