package game.poker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> deck = new ArrayList<Card>();
    //TODO::Remove getDeck to avoid anyone accessing the deck.
    //shuffle the deck or clean one.
    public Deck( boolean isShuffled ) {
        createDeck();
        if (isShuffled) {
            shuffleDeck();
        }
    }

    //deck getter
    public ArrayList<Card> getDeck() {
        return deck;
    }

    //Populate deck (ArrayList) attribute with one of each card (No jokers)
    private void createDeck() {
        String[] suits = {"Heart", "Diamond", "Club", "Spade"};
        for (String suit : suits) {
            for (int i = 1; i < 14; i++) { deck.add(new Card(suit, i)); }
        }
    }

    //shuffle deck and returns list
    protected void shuffleDeck() {
        Collections.shuffle(deck);
    }

    //draw card
    protected Card drawCard() {
        Card card = pickCard(0);
        deleteCard(0);
        return card;
    }

    //draw card part 1: pick the card up
    private Card pickCard(int n) {
        return deck.get(n);
    }

    //draw card part 2: delete card from deck
    private void deleteCard(int n) {
        deck.remove(n);
    }
}