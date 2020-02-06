package com.eointm.cardgame.cards;

import com.eointm.cardgame.exceptions.CardIndexUsedException;

import java.util.HashMap;

public class CardRegistry {
    private HashMap<Integer, Card> cardRegistry;

    public CardRegistry() {
        cardRegistry = new HashMap<>();
    }

    public void addCard(Card c) {
        if (cardRegistry.containsKey(c.getId())) {
            try {
                throw new CardIndexUsedException("Could not add card, index " + c.getId() + " already in use");
            } catch (CardIndexUsedException e) {
                e.printStackTrace();
            }
        }

        cardRegistry.put(c.getId(), c);
    }

    public Card getNewCardById(int id) {
        return cardRegistry.get(id).generateNewInstance();
    }
}
