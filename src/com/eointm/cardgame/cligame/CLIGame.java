package com.eointm.cardgame.cligame;

import com.eointm.cardgame.cards.CardRegistry;
import com.eointm.cardgame.decks.Deck;

import java.util.Scanner;

public class CLIGame {
    public static final String GAME_TITLE = "Card Game";
    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        titleScreen();
    }

    private static void titleScreen() {
        System.out.println("Welcome to " + GAME_TITLE + "!!!");
        System.out.println("Would you like to:\n1) Build a Deck\n2) Battle Opponents");
        int i = s.nextInt();

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
        s.nextLine();
        System.out.println("Welcome to the deck builder!\nPlease name your deck:");
        String deckName = s.nextLine();
        CardRegistry cards = new CardRegistry();
        cards.registerCards();
        Deck d = new Deck(deckName);
        String newCard = "";
        while(!newCard.toLowerCase().equals("n")) {
            if(isInteger(newCard)) {
                d.addCardToDeck(cards.getNewCardById(Integer.parseInt(newCard)));
                System.out.println(d.toString());
            }
            System.out.println("Please enter the id of a card you wish to add to the deck or n if you're finished.");
            newCard = s.nextLine();
        }

    }

    public static boolean isInteger(String s) {
        if (s == null) {
            return false;
        }

        int length = s.length();
        if (length == 0) {
            return false;
        }

        int i = 0;
        if (s.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }

        for (; i < length; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }

        return true;
    }
}
