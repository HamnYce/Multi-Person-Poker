package game.poker;

public class Card {
    protected String suit;
    protected int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    //TODO::Change to '#{value} of #{suit}s'
    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", value=" + value +
                '}';
    }
}
