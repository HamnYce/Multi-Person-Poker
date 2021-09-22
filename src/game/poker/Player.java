package game.poker;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    //TODO::add ToString Method to help with
    private static int counter = 1;
    private String name;
    public int id = counter;
    private int money;
    private final Card[] hand = new Card[2];

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        counter += 1;
    }

    public String getName() { return this.name; }

    public String getHand() { return Arrays.toString(hand); }

    protected void setupHand(Card a, Card b) {
        hand[0] = a;
        hand[1] = b;
    }

    protected int bet() {
        //all in is bet with max amount of money
        Scanner input = new Scanner(System.in);
        System.out.println("How much would you like to bet?");

        int amount = input.nextInt();

        if (enoughMoney(amount)) {
            betMoney(amount);
            return amount;
        }
        System.out.println("Sorry but you don't have enough money");
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
        else return false;
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
