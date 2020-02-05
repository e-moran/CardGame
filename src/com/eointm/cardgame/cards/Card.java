package com.eointm.cardgame.cards;

import com.eointm.cardgame.visual.CardArt;

public class Card {
    private Location location;
    private int manaCost;
    private String name;
    private int id;

    public Card(int id, String name, int manaCost, CardArt art) {
        this.location = Location.DECK;
        this.manaCost = manaCost;
        this.id = id;
        this.name = name;
    }

    public Card(int id, String name, int manaCost, Location location, CardArt art) {
        this.location = location;
        this.manaCost = manaCost;
        this.id = id;
        this.name = name;
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

}
