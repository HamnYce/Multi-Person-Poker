package game.poker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public final List<Player> activePlayers = new ArrayList<>();
    private final List<Card> communityCards = new ArrayList<>();
    public final Deck deck = new Deck(true);
    private int pot;

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public List<Player> getActivePlayers() {
        return activePlayers;
    }

    public int getPot() { return pot; }

    public void addPlayer(String name, int money) {
        Player newPlayer = new Player(name, money);
        activePlayers.add(newPlayer);
    }

    protected void givePocketCards() {
        //TODO::test to see if you can just put deck.drawCard straight into setupHand
        for (Player player : activePlayers) {
            Card card1 = deck.drawCard();
            Card card2 = deck.drawCard();
            player.setupHand(card1, card2);
        }
    }

    public void firstRound() {
        //Opening Deal
        givePocketCards();

        //Place Bets
        //TODO::Move to raise()
        //TODO::Create Check()
        for (Player player : activePlayers) {
            System.out.println("How much would " + player.getName() + " Like to Bet?");
            int playerBet = player.bet();
            while (playerBet == 0) {
                System.out.println("You do not have enough money");
                playerBet = player.bet();
            }
            if (playerBet == -1) {
                removePlayer(player);
                continue;
            }
            pot += playerBet;
        }
        //The flop; Add 3 cards to middle pile.
        flop();
    }


    private void secondRound() {/*second round of betting*/}

    private void thirdRound() {/*third round of betting*/}

    private void flop() {
        for (int i = 0; i < 3; i++) {
            communityCards.add(deck.drawCard());
            //Display Community Cards
            System.out.println("Community Cards Are:" + communityCards.toString());
        }
    }


    protected void removePlayer(Player player) {
        activePlayers.remove(player);
        //NOTE activate remove player when player.fold()
        //for loop ask each player in playRound()
        //TODO::remove active player using playerID
    }
}