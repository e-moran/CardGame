package com.eointm.cardgame.tests;

import com.eointm.cardgame.decks.Deck;
import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.SampleMinionOne;
import com.eointm.cardgame.cards.SampleSpellOne;
import com.eointm.cardgame.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    public Player generateDeck() {
        Deck d = new Deck();

        d.addCardToDeck(new SampleMinionOne());
        d.addCardToDeck(new SampleMinionOne());
        d.addCardToDeck(new SampleSpellOne());
        d.addCardToDeck(new SampleSpellOne());

        return new Player(d);
    }

    @Test
    void drawCard() {
        Player d = generateDeck();

        Card c = d.drawCard();

        assertNotNull(c);
        assertEquals(3, d.getRemainingCards());
    }

    @Test
    void getRemainingCards() {
        Player d = generateDeck();

        assertEquals(4, d.getRemainingCards());
        d.drawCard();
        assertEquals(3, d.getRemainingCards());
    }
}
