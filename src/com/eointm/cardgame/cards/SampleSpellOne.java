package com.eointm.cardgame.cards;

import com.eointm.cardgame.types.AttackableEntity;

/**
 * This is a sample spell card that deals three damage and costs 1 mana
 */
public class SampleSpellOne extends Card implements Spell {

    public SampleSpellOne() {
        super(2, "Sample Spell One", 1, null);
    }

    @Override
    public void castSpell(AttackableEntity entity) {
        if(entity.canCurrentlyBeAttacked())
            entity.takeDamage(1);
    }

    @Override
    public Card generateNewInstance() {
        return new SampleSpellOne();
    }
}
