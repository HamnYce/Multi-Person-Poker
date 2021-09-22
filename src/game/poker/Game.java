package game.poker;

import java.util.*;

public class Game {
    public final Queue<Player> activePlayers = new LinkedList<>();
    //TODO::at end change arraylist to array
    private final List<Card> communityCards = new ArrayList<>();
    public final Deck deck = new Deck(true);
    private int pot = 0;

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public Queue<Player> getActivePlayers() {
        return activePlayers;
    }

    public int getPot() { return pot; }

    public Card getCard() { return deck.drawCard(); }

    public Player newPlayer(String name, int money) {
        return new Player(name, money);
    }

    public void givePocketCards() {
        //TODO::Make Protected at end
        for (Player player : activePlayers) {
            player.setupHand(getCard(), getCard());
        }
    }

    public void joinPlayers() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many players?");
        int numberOfPlayers = input.nextInt();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.printf("Player %d please enter your details: %n", i+1);

            System.out.println("Player Name: ");
            String name = input.next();
            System.out.println("\nPlayer Money: ");
            int money = input.nextInt();
            activePlayers.add(newPlayer(name, money));
        }
    }

    public void cycleChoice() {
        Scanner input = new Scanner(System.in);
        int nextRound = activePlayers.size();
        int currentBet = 0;
        Outerloop:
        while (true) {
            if (nextRound == 0 || activePlayers.size() == 1) { break; }

            Player currentPlayer = activePlayers.peek();

            System.out.println(currentPlayer.getName() + "1 for fold, 2 for call/check, 3 for raise");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Folded");
                    activePlayers.remove();
                    break Outerloop;
                case 2:
                    System.out.println("called");
                    nextRound--;
                    break;
                case 3:
                    System.out.println("raised");
                    pot += currentPlayer.bet();
                    nextRound = activePlayers.size();
                    break;
            }
            backOfTheLine(activePlayers.peek());
        }
        System.out.println("current active players" + activePlayers);
        System.out.println("cycle ended");
    }

    private void flop() {
        for (int i = 0; i < 3; i++) {
            communityCards.add(getCard());
            //Display Community Cards
        }
        System.out.println("Community Cards Are:" + communityCards);
    }

    protected void addPlayer(Player player) { activePlayers.add(player); }

    protected void removePlayer() { activePlayers.remove(); }

    protected void backOfTheLine(Player player) { addPlayer(player); removePlayer();}

    public void TEST_DisplayHands() {
        for (Player player : activePlayers) {
            System.out.println(player.getHand());
        }
    }
}