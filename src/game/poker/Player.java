package game.poker;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    //TODO::add ToString Method to help with
    private static int counter = 1;
    private String name;
    public int id = counter;
    private int money;
    protected int callAmount = 0;
    private final Card[] hand = new Card[2];

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        counter += 1;
    }

    public String getName() { return this.name; }

    public String getHand() { return Arrays.toString(hand); }

    protected void setupHand(Card a, Card b) {
        hand[0] = a; hand[1] = b;
    }

    protected int call() {
        if (enoughMoney(callAmount)) {
            betMoney(callAmount);
            System.out.println("You called for $" + callAmount);
            return callAmount;
        }
        System.out.println("you don't have enough money");
        return 0;
    }

    protected int raise() {
        Scanner input = new Scanner(System.in);

        System.out.println("How much would you like to raise?");
        int raiseAmount = input.nextInt();
        int totalAmount = raiseAmount + callAmount;
        if (enoughMoney(totalAmount)) {
            betMoney(totalAmount);
            System.out.println("You have raised by $" + raiseAmount);
            return totalAmount;
        }
        System.out.println("You don't have enough money");
        return 0;
    }

    protected int fold() {
        return -1;
    }

    protected void check(int amount) {
        //contains enoughMoney(amount) and if yes then can check else
        //has to go all in.
    }

    protected void gainMoney(int amount) {
        this.money += amount;
    }

    protected void betMoney(int amount) { this.money -= amount; }

    private boolean enoughMoney(int amount) {
        if (this.money - amount >= 0) return true;

        return false;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", money=" + money +
                ", hand=" + Arrays.toString(hand) +
                "}\n";
    }
}
