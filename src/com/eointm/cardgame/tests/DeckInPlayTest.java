package com.eointm.cardgame.tests;

import com.eointm.cardgame.Deck;
import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.SampleMinionOne;
import com.eointm.cardgame.cards.SampleSpellOne;
import com.eointm.cardgame.player.DeckInPlay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckInPlayTest {

    public DeckInPlay generateDeck() {
        Deck d = new Deck();

        d.addCardToDeck(new SampleMinionOne());
        d.addCardToDeck(new SampleMinionOne());
        d.addCardToDeck(new SampleSpellOne());
        d.addCardToDeck(new SampleSpellOne());

        return new DeckInPlay(d);
    }

    @Test
    void drawCard() {
        DeckInPlay d = generateDeck();

        Card c = d.drawCard();

        assertNotNull(c);
        assertEquals(3, d.getRemainingCards());
    }

    @Test
    void getRemainingCards() {
        DeckInPlay d = generateDeck();

        assertEquals(4, d.getRemainingCards());
        d.drawCard();
        assertEquals(3, d.getRemainingCards());
    }
}
