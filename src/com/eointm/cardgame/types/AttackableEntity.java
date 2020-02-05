package com.eointm.cardgame.types;

public interface AttackableEntity {
    void takeDamage(int damage);
    boolean canCurrentlyBeAttacked();
    int getCounterAttackDamage();
}
