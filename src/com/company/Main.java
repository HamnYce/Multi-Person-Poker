package com.company;

import game.poker.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        //System.out.println("deck size" + game.deck.getDeck().size());

        game.addPlayer("First Player", 1000);
        game.addPlayer("Second Player", 1000);
        game.addPlayer("Third Player", 1000);
        game.addPlayer("Fourth Player", 1000);

        game.firstRound();

    }
}
