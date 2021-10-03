package com.company;

import game.poker.Game;
import game.poker.Menu;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("current pot: " + game.getPot());


        game.joinPlayers();
        //pocket/hole cards
        game.givePocketCards();
        game.cycleChoice();
        //flop
        game.flop();
        game.cycleChoice();
        //fourth card
        game.revealCard();
        game.cycleChoice();
        //final card
        game.revealCard();
        game.cycleChoice();

        System.out.println("current pot: " + game.getPot());
    }
}
