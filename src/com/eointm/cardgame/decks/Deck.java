package com.eointm.cardgame.decks;

import com.eointm.cardgame.attributes.Attribute;
import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.CardColour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
    String deckName;
    ArrayList<Card> deck;
    ArrayList<Attribute> attrs;
    public static final CardColour NEUTRAL_COLOUR = CardColour.GREY;
    public static final int MAX_DECK_SIZE = 30;

    public Deck(String name) {
        this.deckName = name;
        deck = new ArrayList<>(MAX_DECK_SIZE);
        attrs = new ArrayList<>(3);
    }

    public Deck() {
        deck = new ArrayList<>(MAX_DECK_SIZE);
        attrs = new ArrayList<>(3);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getRandomisedDeck() {
        ArrayList<Card> deck = this.deck;

        Collections.shuffle(deck);

        return deck;
    }

    public void addAttribute(Attribute a) {
        attrs.add(a);
    }

    public int getDiffAttrColourCount() {
        return getDeckColours().size();
    }

    public int getAttributeCount() {
        return attrs.size();
    }

    public ArrayList<Attribute> getAttributes() {
        return attrs;
    }

    public void addCardToDeck(Card c) {
        deck.add(c);
    }

    public int getCardCount() {
        return deck.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Your deck " + this.deckName + " contains:\n");
        for(Card card: deck) {
            sb.append(card.getId());
            sb.append(": ");
            sb.append(card.getName());
            sb.append("\n");
        }

        return sb.toString();
    }

    public int getMaxDuplicates() {
        return 4 - getDiffAttrColourCount();
    }

    public ArrayList<CardColour> getDeckColours() {
        ArrayList<CardColour> diffColours = new ArrayList<>(5);

        for (Attribute attr : attrs) {
            if (!diffColours.contains(attr.getColour())) {
                diffColours.add(attr.getColour());
            }
        }

        return diffColours;
    }

    public boolean canCardEnterDeck(Card c) {
        List<Card> cardIds = deck.stream().filter(card -> card.getId() == c.getId()).collect(Collectors.toList());

        if(cardIds.size() >= getMaxDuplicates())
            return false;

        if(getCardCount() >= MAX_DECK_SIZE)
            return false;

        return getDeckColours().contains(c.getCardColour()) || c.getCardColour() == NEUTRAL_COLOUR;
    }
}
