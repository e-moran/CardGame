package com.eointm.cardgame.cards;

import com.eointm.cardgame.exceptions.CardIndexUsedException;

import java.util.ArrayList;

public class CardRegistry {
    private ArrayList<Card> cardRegistry;

    public CardRegistry() {
        cardRegistry = new ArrayList<>();
    }

    public void addCard(Card c) {
        if(cardRegistry.get(c.getId()) != null)
            try {
                throw new CardIndexUsedException("Could not add card, index already used");
            } catch (CardIndexUsedException e) {
                e.printStackTrace();
            }

        cardRegistry.add(c.getId(), c);
    }

    public Card getNewCardById(int id) {
        return cardRegistry.get(id).generateNewInstance();
    }


}
