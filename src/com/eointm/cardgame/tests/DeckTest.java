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

        test.addCardToDeck(new Minion(1,1,1, "", 1, null, CardColour.GREY));
        assertEquals(1, test.getCardCount());

        test.addCardToDeck(new Minion(1, 1, 1, "", 1, null, CardColour.BLUE));
        assertEquals(2, test.getCardCount());

        test.addCardToDeck(new Minion(1, 1, 1, "", 1, null, CardColour.BLUE));
        assertEquals(3, test.getCardCount());
    }

    @Test
    void getMaxDuplicates() {
        Deck test = new Deck();

        test.addAttribute(new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        test.addAttribute(new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        test.addAttribute(new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });

        assertEquals(3, test.getMaxDuplicates());

        Deck testTwo = new Deck();

        testTwo.addAttribute(new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        testTwo.addAttribute(new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        testTwo.addAttribute(new Attribute(CardColour.YELLOW) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });

        assertEquals(2, testTwo.getMaxDuplicates());

        Deck testThree = new Deck();

        testThree.addAttribute(new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        testThree.addAttribute(new Attribute(CardColour.RED) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        testThree.addAttribute(new Attribute(CardColour.YELLOW) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });

        assertEquals(1, testThree.getMaxDuplicates());
    }

    @Test
    void canCardEnterDeck() {
        Deck test = new Deck();

        test.addAttribute(new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        test.addAttribute(new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        test.addAttribute(new Attribute(CardColour.RED) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });

        assertTrue(test.canCardEnterDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE)));
        test.addCardToDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE));
        assertTrue(test.canCardEnterDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE)));
        test.addCardToDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE));
        test.addCardToDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE));
        assertFalse(test.canCardEnterDeck(new Minion(1, 1, 1, "", 1, null, CardColour.YELLOW)));
        assertTrue(test.canCardEnterDeck(new Minion(1, 1, 2, "", 1, null, CardColour.BLUE)));
        assertFalse(test.canCardEnterDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE)));


        Deck testTwo = new Deck();

        testTwo.addAttribute(new Attribute(CardColour.YELLOW) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        testTwo.addAttribute(new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });
        testTwo.addAttribute(new Attribute(CardColour.RED) {
            @Override
            public void applyAttributeToCard(Card card) {
            }
        });

        testTwo.addCardToDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE));
        testTwo.addCardToDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE));
        testTwo.addCardToDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE));

        assertFalse(testTwo.canCardEnterDeck(new Minion(1, 1, 1, "", 1, null, CardColour.PURPLE)));
        assertFalse(testTwo.canCardEnterDeck(new Minion(1, 1, 0, "", 1, null, CardColour.BLUE)));
    }
}
