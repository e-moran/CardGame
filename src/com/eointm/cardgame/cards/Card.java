package com.eointm.cardgame.cards;

import com.eointm.cardgame.decks.Deck;
import com.eointm.cardgame.attributes.Attribute;
import com.eointm.cardgame.visual.CardArt;

public abstract class Card {
    private Location location;
    private int manaCost;
    private String name;
    private int id;
    private CardArt art;
    private CardColour cardColour;
    private CardRarity cardRarity;

    public Card(int id, String name, int manaCost, CardArt art, CardColour colour) {
        this(id, name, manaCost, Location.DECK, art, colour, CardRarity.SILICON);
    }

    public Card(int id, String name, int manaCost, Location location, CardArt art, CardColour colour) {
        this(id, name, manaCost, location, art, colour, CardRarity.SILICON);
    }

    public Card(int id, String name, int manaCost, Location location, CardArt art, CardColour colour, CardRarity rarity) {
        this.location = location;
        this.manaCost = manaCost;
        this.id = id;
        this.name = name;
        this.art = art;
        this.cardColour = colour;
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

    public CardColour getCardColour() {
        return cardColour;
    }

    public abstract Card generateNewInstance();

    public void applyDeckAttributes(Deck d) {
        for(Attribute attrs: d.getAttributes()) {
            attrs.applyAttributeToCard(this);
        }
    }
}
