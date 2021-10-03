package game.poker;

import java.util.*;

public class Game {
    public final Queue<Player> activePlayers = new LinkedList<>();
    //TODO::at end change arraylist<Card> to array
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
    public Card getRandomCard() { return deck.drawCard(); }
    public Player newPlayer(String name, int money) {
        return new Player(name, money);
    }

    public void givePocketCards() {
        //TODO::Make Protected at end
        for (Player player : activePlayers) {
            player.setupHand(getRandomCard(), getRandomCard());
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
        Outerloop:
        while (true) {
            if (nextRound == 0 || activePlayers.size() == 1) { break; }

            Player currentPlayer = activePlayers.peek();
            String playerName = currentPlayer.getName();

            Menu.getChoiceList(playerName);

            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    Menu.getFolded(playerName);
                    removePlayer();
                    continue Outerloop;
                }
                case 2 -> {
                    //we will assume for now that the player has sufficient money
                    Menu.getCalled(playerName);
                    pot = currentPlayer.call();
                    nextRound--;
                }
                case 3 -> {
                    Menu.getRaised(playerName);
                    System.out.println("How much would you like to raise?");
                    int[] temp = currentPlayer.raise();

                    int total = temp[0]; //totalAmount
                    int raise = temp[1]; //raiseAmount
                    if (total == 0) {
                        continue Outerloop;
                    }
                    pot += total;
                    incrementCallAmount(currentPlayer, raise);
                    //subtract by one because we are technically calling our own raise.
                    nextRound = activePlayers.size() - 1;
                }
                default -> {
                    System.out.println("invalid entry");
                }
            }
            backOfTheLine(currentPlayer);
        }
        System.out.println("current active players" + activePlayers);
        System.out.println("Current Pot is: $" + pot);
    }

    //TODO::private
    public void flop() {
        for (int i = 0; i < 3; i++) {
            communityCards.add(getRandomCard());
            //Display Community Cards
        }
        System.out.println("Community Cards Are:" + communityCards);
    }

    //TODO::private
    public void revealCard() {
        communityCards.add(getRandomCard());
        System.out.println("Community Cards:\n" + communityCards);
    }

    protected void addPlayer(Player player) { activePlayers.add(player); }

    protected void removePlayer() { activePlayers.remove(); }

    protected void backOfTheLine(Player player) { addPlayer(player); removePlayer();}

    protected void incrementCallAmount(Player currentPlayer, int amount) {
        for (Player player : activePlayers) {
            if (player != currentPlayer) {
                player.increaseCallAmount(amount);
            }
        }
    }

    public void TEST_DisplayHands() {
        for (Player player : activePlayers) {
            System.out.println(player.getHand());
        }
    }
}