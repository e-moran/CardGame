package com.eointm.cardgame.tests;

import com.eointm.cardgame.cards.CardColour;
import com.eointm.cardgame.cards.CardRarity;
import com.eointm.cardgame.cards.Location;
import com.eointm.cardgame.cards.Minion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinionTest {

    @Test
    void attack() {
        Minion testMinionOne = new Minion(5, 4, 3, "", 4, null, CardColour.BLUE);
        Minion testMinionTwo = new Minion(7, 6,  4, "", 2, null,CardColour.BLUE);

        testMinionOne.attack(testMinionTwo);

        assertEquals(-3, testMinionOne.getHealth());
        assertEquals(1, testMinionTwo.getHealth());
        assertEquals(Location.GRAVEYARD, testMinionOne.getLocation());
    }

    @Test
    void getAttack() {
        assertEquals(4, new Minion(4, 4, 4, "", 4, null, CardColour.BLUE).getAttack());
    }

    @Test
    void getHealth() {
        assertEquals(4, new Minion(4, 4, 4, "", 4, null, CardColour.BLUE).getHealth());
    }

    @Test
    void takeDamage() {
        Minion testMinion = new Minion(5, 4, 1, "", 3, null, CardColour.BLUE);

        testMinion.takeDamage(3);
        assertEquals(1, testMinion.getHealth());

        testMinion.takeDamage(2);
        assertEquals(-1, testMinion.getHealth());
        assertEquals(Location.GRAVEYARD, testMinion.getLocation());

        Minion testMinionTwo = new Minion(5, 2, 2, 1, "", 3, Location.BOARD, null, CardColour.BLUE, CardRarity.SILICON);

        testMinionTwo.takeDamage(1);
        assertEquals(1, testMinionTwo.getForcefield());

        testMinionTwo.takeDamage(2);
        assertEquals(0, testMinionTwo.getForcefield());
        assertEquals(1, testMinionTwo.getHealth());

        testMinionTwo.takeDamage(2);
        assertEquals(-1, testMinionTwo.getHealth());
        assertEquals(Location.GRAVEYARD, testMinionTwo.getLocation());
    }

    @Test
    void generateNewInstance() {
        Minion testMinion = new Minion(5, 4, 1, "", 3, null, CardColour.BLUE);

        assertEquals(testMinion, testMinion);
        assertNotEquals(testMinion, testMinion.generateNewInstance());
    }
}
