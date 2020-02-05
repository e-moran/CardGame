package com.eointm.cardgame.tests;

import com.eointm.cardgame.Deck;
import com.eointm.cardgame.attributes.Attribute;
import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.CardColour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void getRandomisedDeck() {
    }

    @Test
    void addAttribute() {
        Deck test = new Deck();

        test.addAttribute(new Attribute(CardColour.BLACK));
        assertEquals(1, test.getAttributeCount());

        test.addAttribute(new Attribute(CardColour.BLACK));
        assertEquals(2, test.getAttributeCount());

        test.addAttribute(new Attribute(CardColour.BLACK));
        assertEquals(3, test.getAttributeCount());
    }

    @Test
    void getDiffAttrColourCount() {
        Deck test = new Deck();
        test.addAttribute(new Attribute(CardColour.BLACK));
        test.addAttribute(new Attribute(CardColour.BLACK));
        test.addAttribute(new Attribute(CardColour.BLACK));
        assertEquals(1, test.getDiffAttrColourCount());

        test = new Deck();
        test.addAttribute(new Attribute(CardColour.BLACK));
        test.addAttribute(new Attribute(CardColour.GREEN));
        test.addAttribute(new Attribute(CardColour.BLUE));
        assertEquals(3, test.getDiffAttrColourCount());

        test = new Deck();
        test.addAttribute(new Attribute(CardColour.BLACK));
        test.addAttribute(new Attribute(CardColour.BLUE));
        test.addAttribute(new Attribute(CardColour.BLUE));
        assertEquals(2, test.getDiffAttrColourCount());
    }

    @Test
    void addCardToDeck() {
        Deck test = new Deck();

        test.addCardToDeck(new Card(1, "", 1, null));
        assertEquals(1, test.getCardCount());

        test.addCardToDeck(new Card(1, "", 1, null));
        assertEquals(2, test.getCardCount());

        test.addCardToDeck(new Card(1, "", 1, null));
        assertEquals(3, test.getCardCount());

    }
}
