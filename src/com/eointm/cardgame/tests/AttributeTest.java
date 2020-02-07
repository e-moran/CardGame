package com.eointm.cardgame.tests;

import com.eointm.cardgame.Deck;
import com.eointm.cardgame.attributes.Attribute;
import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.CardColour;
import com.eointm.cardgame.cards.Minion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttributeTest {

    @Test
    void applyAttributeToCard() {
        //Test attribute that doubles health
        Attribute testAttrOne = new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
                if(card instanceof Minion) {
                    Minion m = (Minion) card;
                    m.setHealth(m.getHealth()*2);
                }
            }
        };

        //Test attribute that adds one attack
        Attribute testAttrTwo = new Attribute(CardColour.BLUE) {
            @Override
            public void applyAttributeToCard(Card card) {
                if(card instanceof Minion) {
                    Minion m = (Minion) card;
                    m.setAttack(m.getAttack() + 1);
                }
            }
        };

        Minion testMinion = new Minion(5, 4, 3, "", 4, null);

        Deck d = new Deck();
        d.addAttribute(testAttrOne);
        d.addAttribute(testAttrTwo);

        testMinion.applyDeckAttributes(d);

        assertEquals(8, testMinion.getHealth());
        assertEquals(6, testMinion.getAttack());
    }
}