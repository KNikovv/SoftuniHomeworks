package cardranks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardRank {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String rank = buffReader.readLine().trim();
        String suit = buffReader.readLine().trim();

        int totalPower = Suits.valueOf(suit).getRankSuit() + Ranks.valueOf(rank).getRankPower();

        System.out.printf("Card name: %s of %s; Card power: %d",rank,suit,totalPower);

    }
}

enum Ranks {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int rankPower;

    Ranks(int power) {
        this.setRankPower(power);
    }

    private void setRankPower(int rankPower) {
        this.rankPower = rankPower;
    }

    public int getRankPower() {
        return this.rankPower;
    }

}
enum Suits{

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int rankSuit;

    Suits(int power) {
        this.setRankSuit(power);
    }

    private void setRankSuit(int rankSuit) {
        this.rankSuit = rankSuit;
    }

    public int getRankSuit() {
        return this.rankSuit;
    }
}