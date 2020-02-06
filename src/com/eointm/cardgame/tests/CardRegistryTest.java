package com.eointm.cardgame.tests;

import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.CardRegistry;
import com.eointm.cardgame.cards.SampleMinionOne;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardRegistryTest {

    @Test
    void getNewCardById() {
        CardRegistry reg = new CardRegistry();
        Card c = new SampleMinionOne();

        reg.addCard(c);

        assertNotEquals(c, reg.getNewCardById(c.getId()));


    }
}
