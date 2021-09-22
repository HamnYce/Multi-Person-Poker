package com.company;

import game.poker.Game;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("deck size" + game.deck.getDeck().size());

        game.joinPlayers();
        game.givePocketCards();
        game.cycleChoice();

        System.out.println("deck size" + game.deck.getDeck().size());
    }
}
