package com.eointm.cardgame;

import com.eointm.cardgame.attributes.Attribute;
import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.CardColour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
    ArrayList<Card> deck;
    ArrayList<Attribute> attrs;
    private static final CardColour NEUTRAL_COLOUR = CardColour.GREY;

    public Deck() {
        deck = new ArrayList<>(30);
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

        return getDeckColours().contains(c.getCardColour()) || c.getCardColour() == NEUTRAL_COLOUR;
    }
}
