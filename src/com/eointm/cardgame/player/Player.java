package com.eointm.cardgame.player;

import com.eointm.cardgame.decks.Deck;
import com.eointm.cardgame.cards.Card;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> deck;
    private int currMana;

    public Player(Deck baseDeck) {
        deck = baseDeck.getRandomisedDeck();
        currMana = 1;
    }

    public Card drawCard() {
        Card c  = deck.get(0);
        deck.remove(0);
        return c;
    }

    public int getRemainingCards() {
        return deck.size();
    }

    public void setCurrMana(int mana) {
        this.currMana = mana;
    }

    public int getCurrMana() {
        return currMana;
    }


}
