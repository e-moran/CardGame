package com.eointm.cardgame.attributes;

import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.CardColour;

public abstract class Attribute {

    private CardColour colour;

    public Attribute(CardColour colour) {
        this.colour = colour;
    }

    public CardColour getColour() {
        return colour;
    }

    /**
     * Applies the attribute to a specified card if the attribute applies to cards
     * @param card The card to apply the attribute to
     */
    public abstract void applyAttributeToCard(Card card);
}
