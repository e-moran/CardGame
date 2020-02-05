package com.eointm.cardgame;

import com.eointm.cardgame.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>(30);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getRandomisedDeck() {
        ArrayList<Card> deck = this.deck;

        Collections.shuffle(deck);

        return deck;
    }

    public void addCardToDeck(Card c) {
        deck.add(c);
    }
}
