package com.eointm.cardgame.attributes;

import com.eointm.cardgame.cards.CardColour;

public class Attribute {

    private CardColour colour;

    public Attribute(CardColour colour) {
        this.colour = colour;
    }

    public CardColour getColour() {
        return colour;
    }
}
