package com.eointm.cardgame.cards;

import com.eointm.cardgame.Deck;
import com.eointm.cardgame.attributes.Attribute;
import com.eointm.cardgame.visual.CardArt;

public abstract class Card {
    private Location location;
    private int manaCost;
    private String name;
    private int id;
    private CardArt art;

    public Card(int id, String name, int manaCost, CardArt art) {
        this.location = Location.DECK;
        this.manaCost = manaCost;
        this.id = id;
        this.name = name;
        this.art = art;
    }

    public Card(int id, String name, int manaCost, Location location, CardArt art) {
        this.location = location;
        this.manaCost = manaCost;
        this.id = id;
        this.name = name;
        this.art = art;
    }

    public Location getLocation() {
        return location;
    }

    public void moveCard(Location location) {
        this.location = location;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CardArt getCardArt() {
        return art;
    }

    public abstract Card generateNewInstance();

    public void applyDeckAttributes(Deck d) {
        for(Attribute attrs: d.getAttributes()) {
            attrs.applyAttributeToCard(this);
        }
    }
}
