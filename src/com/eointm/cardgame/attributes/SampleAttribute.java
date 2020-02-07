package com.eointm.cardgame.attributes;

import com.eointm.cardgame.cards.Card;
import com.eointm.cardgame.cards.CardColour;

public class SampleAttribute extends Attribute {
    public SampleAttribute(CardColour colour) {
        super(colour);
    }

    @Override
    public void applyAttributeToCard(Card card) {

    }
}
