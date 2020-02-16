package com.eointm.cardgame.cards;

import com.eointm.cardgame.types.AttackableEntity;
import com.eointm.cardgame.visual.CardArt;

public class Minion extends Card implements AttackableEntity {

    private int attack, health, forcefield;

    public Minion(int attack, int health, int id, String name, int manaCost, CardArt art, CardColour colour) {
        this(attack, health, id, name, manaCost, Location.DECK, art, colour);
    }

    public Minion(int attack, int health, int id, String name, int manaCost, Location location, CardArt art, CardColour colour) {
        this(attack, health, 0, id, name, manaCost, location, art, colour, CardRarity.SILICON);
    }

    public Minion(int attack, int health, int forcefield, int id, String name, int manaCost, Location location, CardArt art, CardColour colour, CardRarity rarity) {
        super(id, name, manaCost, location, art, colour, rarity);
        this.attack = attack;
        this.health = health;
        this.forcefield = forcefield;
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

    public int getForcefield() {
        return forcefield;
    }

    public void setForcefield(int forcefield) {
        this.forcefield = forcefield;
    }

    @Override
    public void takeDamage(int damage) {
        int forcefieldDmg;
        int remainingDmg;

        if(getForcefield() < damage) {
            forcefieldDmg = getForcefield();
            remainingDmg = damage - forcefieldDmg;
        } else {
            forcefieldDmg = damage;
            remainingDmg = 0;
        }

        setForcefield(getForcefield() - forcefieldDmg);
        setHealth(getHealth() - remainingDmg);

        if(getHealth() <= 0)
            die();
    }

    @Override
    public Card generateNewInstance() {
        return new Minion(attack, health, getId(), getName(), getManaCost(), getLocation(), getCardArt(), getCardColour());
    }
}
