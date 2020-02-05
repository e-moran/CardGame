package com.eointm.cardgame.cards;

import com.eointm.cardgame.types.AttackableEntity;
import com.eointm.cardgame.visual.CardArt;

public class Minion extends Card implements AttackableEntity {

    private int attack, health;

    public Minion(int attack, int health, int id, String name, int manaCost, CardArt art) {
        super(id, name, manaCost, Location.DECK, art);

        this.attack = attack;
        this.health = health;
    }

    public Minion(int attack, int health, int id, String name, int manaCost, Location location, CardArt art) {
        super(id, name, manaCost, location, art);

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

    public int getHealth() {
        return health;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;

        if(getHealth() <= 0)
            die();
    }
}
