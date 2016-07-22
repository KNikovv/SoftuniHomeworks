package cardgame.models;

import cardgame.enums.Rank;
import cardgame.enums.Suit;
import cardgame.interfaces.Deck;

import java.util.Map;
import java.util.TreeMap;

public class DeckImpl implements Deck {

    private Map<String, Card> deck;

    public DeckImpl() {
        this.generateCards();
    }

    @Override
    public Card receiveCardFromDeck(String cardName) {
        Card card;
        if (!this.deck.containsKey(cardName)) {
            throw new IllegalArgumentException("No such card exists.");
        }
        if (this.deck.get(cardName) == null) {
            throw new IllegalArgumentException("Card is not in the deck.");
        }
        card = this.deck.get(cardName);
        this.deck.put(cardName, null);
        return card;
    }

    private void generateCards() {
        this.deck = new TreeMap<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                this.deck.put(card.toString(), card);
            }
        }
    }
}
