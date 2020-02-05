package com.eointm.cardgame.player;

import com.eointm.cardgame.Deck;
import com.eointm.cardgame.cards.Card;

import java.util.ArrayList;

public class DeckInPlay {
    private ArrayList<Card> deck;

    public DeckInPlay(Deck baseDeck) {
        deck = baseDeck.getRandomisedDeck();
    }

    public Card drawCard() {
        Card c  = deck.get(0);
        deck.remove(0);
        return c;
    }

    public int getRemainingCards() {
        return deck.size();
    }


}
