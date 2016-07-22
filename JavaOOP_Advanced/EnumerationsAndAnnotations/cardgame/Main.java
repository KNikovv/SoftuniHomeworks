package cardgame;

import cardgame.interfaces.CardPlayer;
import cardgame.interfaces.Deck;
import cardgame.models.Card;
import cardgame.models.CardPlayerImpl;
import cardgame.models.DeckImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader bufferedReader;
    private static Deck deck;

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        deck = new DeckImpl();
    }

    public static void main(String[] args) throws IOException {

        String playerOneName = bufferedReader.readLine();
        String playerTwoName = bufferedReader.readLine();

        CardPlayer firstPlayer = new CardPlayerImpl(playerOneName);
        CardPlayer secondPlayer = new CardPlayerImpl(playerTwoName);

        addCards(firstPlayer);
        addCards(secondPlayer);

        CardPlayer winner = determineWinner(firstPlayer, secondPlayer);
        System.out.printf("%s wins with %s.", winner.getName(), winner.getHighestCard());

    }

    private static void addCards(CardPlayer player) throws IOException {
        for (int index = 0; index < 5; index++) {
            String cardName = bufferedReader.readLine();
            try {
                Card card = deck.receiveCardFromDeck(cardName);
                player.addCard(card);
            } catch (IllegalArgumentException ex) {
                index--;  // if a card is invalid index-- so player can add another card
                System.out.println(ex.getMessage());
            }
        }
    }

    private static CardPlayer determineWinner(CardPlayer firstPlayer, CardPlayer secondPlayer) {

        Card firstPlayerBestCard = firstPlayer.getHighestCard();
        Card secondPlayerBestCard = secondPlayer.getHighestCard();

        int result = firstPlayerBestCard.compareTo(secondPlayerBestCard);

        return result > 0 ? secondPlayer : firstPlayer;
    }
}
