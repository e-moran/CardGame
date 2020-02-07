package com.eointm.cardgame.tests;

import com.eointm.cardgame.Deck;
import com.eointm.cardgame.attributes.Attribute;
import com.eointm.cardgame.attributes.SampleAttribute;
import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.CardColour;
import com.eointm.cardgame.cards.Minion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void getRandomisedDeck() {
    }

    @Test
    void addAttribute() {
        Deck test = new Deck();

        test.addAttribute(new SampleAttribute(CardColour.GREY));
        assertEquals(1, test.getAttributeCount());

        test.addAttribute(new SampleAttribute(CardColour.GREY));
        assertEquals(2, test.getAttributeCount());

        test.addAttribute(new SampleAttribute(CardColour.GREY));
        assertEquals(3, test.getAttributeCount());
    }

    @Test
    void getDiffAttrColourCount() {
        Deck test = new Deck();
        test.addAttribute(new SampleAttribute(CardColour.GREY));
        test.addAttribute(new SampleAttribute(CardColour.GREY));
        test.addAttribute(new SampleAttribute(CardColour.GREY));
        assertEquals(1, test.getDiffAttrColourCount());

        test = new Deck();
        test.addAttribute(new SampleAttribute(CardColour.GREY));
        test.addAttribute(new SampleAttribute(CardColour.YELLOW));
        test.addAttribute(new SampleAttribute(CardColour.BLUE));
        assertEquals(3, test.getDiffAttrColourCount());

        test = new Deck();
        test.addAttribute(new SampleAttribute(CardColour.YELLOW));
        test.addAttribute(new SampleAttribute(CardColour.BLUE));
        test.addAttribute(new SampleAttribute(CardColour.BLUE));
        assertEquals(2, test.getDiffAttrColourCount());
    }

    @Test
    void addCardToDeck() {
        Deck test = new Deck();

        test.addCardToDeck(new Minion(1,1,1, "", 1, null));
        assertEquals(1, test.getCardCount());

        test.addCardToDeck(new Minion(1, 1, 1, "", 1, null));
        assertEquals(2, test.getCardCount());

        test.addCardToDeck(new Minion(1, 1, 1, "", 1, null));
        assertEquals(3, test.getCardCount());

    }
}
