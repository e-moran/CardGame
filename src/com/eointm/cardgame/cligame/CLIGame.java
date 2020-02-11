package com.eointm.cardgame.cligame;

import com.eointm.cardgame.decks.Deck;

import java.util.Scanner;

public class CLIGame {
    public static final String GAME_TITLE = "Card Game";

    public static void main(String[] args) {
        titleScreen();
    }

    private static void titleScreen() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to " + GAME_TITLE + "!!!");
        System.out.println("Would you like to:\n1) Build a Deck\n2)Battle Opponents");
        int i = s.nextInt();
        s.close();

        switch(i) {
            case 1:
                deckBuilder();
                break;
            case 2:
                break;
            default:
                titleScreen();
                break;
        }
    }

    public static void deckBuilder() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the deck builder!\nPlease name your deck:");
        String deckName = s.nextLine();
        Deck d = new Deck(deckName);
        String newCard = "";
        while(!newCard.toLowerCase().equals("n")) {
            
            System.out.println("Please enter the id of a card you wish to add to the deck");
            newCard = s.nextLine();
        }

    }
}
