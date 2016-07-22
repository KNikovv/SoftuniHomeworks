package cardgame.interfaces;

import cardgame.models.Card;

public interface CardPlayer extends Player {

    void addCard(Card card);

    Card getHighestCard();
}
