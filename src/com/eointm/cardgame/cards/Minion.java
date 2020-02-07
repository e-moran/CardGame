package com.eointm.cardgame.cards;

import com.eointm.cardgame.Deck;
import com.eointm.cardgame.attributes.Attribute;
import com.eointm.cardgame.types.AttackableEntity;
import com.eointm.cardgame.visual.CardArt;

public class Minion extends Card implements AttackableEntity {

    private int attack, health;

    public Minion(int attack, int health, int id, String name, int manaCost, CardArt art, CardColour colour) {
        super(id, name, manaCost, Location.DECK, art, colour);

        this.attack = attack;
        this.health = health;
    }

    public Minion(int attack, int health, int id, String name, int manaCost, Location location, CardArt art, CardColour colour) {
        super(id, name, manaCost, location, art, colour);

        this.attack = attack;
        this.health = health;
    }

    public boolean attack(AttackableEntity entity) {
        if(attack == 0 || !entity.canCurrentlyBeAttacked())
            return false;

        entity.takeDamage(attack);
        if(this.canCurrentlyBeAttacked())
            takeDamage(entity.getCounterAttackDamage());

        return true;
    }

    private void die() {
        moveCard(Location.GRAVEYARD);
    }

    public boolean canCurrentlyBeAttacked() {
        return true;
    }

    @Override
    public int getCounterAttackDamage() {
        return getAttack();
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);

        if(getHealth() <= 0)
            die();
    }

    @Override
    public Card generateNewInstance() {
        return new Minion(attack, health, getId(), getName(), getManaCost(), getLocation(), getCardArt(), getCardColour());
    }
}
