import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Deck {

    private Card[] deck;
    private int cardsRemaining;
    
    public Deck(boolean shuffled) {
        this.deck = new Card[52];
        int currentIndex = deck.length - 1;

        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                Card c = new Card(r, s);
                deck[currentIndex] = c;
                currentIndex--;
            }
        }
        cardsRemaining = 52;

        if (shuffled == true) {
            shuffle();
        }
        

    }

    public void shuffle() {
        Random r = new Random();
        Card temp;
        
        for (int i = deck.length -1; i >= 0; i--) {
            int j = r.nextInt(i + 1); // inclusive
            temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public int getCardsRemaining() {
        return cardsRemaining;
    }

    /**
     * Get the size of the deck 
     * @return
     */
    public int getSize() {
        return cardsRemaining;
    }

    /**
     * Every card must be differnet in a deck. Sanity check here.
     * @return a true if there is duplicate cards
     */
    public boolean hasDuplicates() {
        Set<Card> set = new HashSet();

        for (Card c : deck) {
            set.add(c);
        }

        return set.size() < getSize();
    }

    /**
     * Get a card at a specific index. Useful in a loop
     * @param index to get card
     * @return Card at index
     */
    public Card getCard(int index) {
        Card card = null;
        if (deck[index] != null) {
            card = deck[index];
        }

        return card;
    }

    /**
     * Flip each card in deck
     */
    public void flip() {
        for (Card c : deck) {
            c.flip();
        }
    }

    public Card draw() {
        Card card = null;
        if (!isEmpty()) {
            card = topCard();
            
            cardsRemaining--;
        }

        return card;
    }

    public boolean isEmpty() {
        return cardsRemaining == 0;
    }

    public Card topCard() {
        Card card = null;
        if (!isEmpty()) {
            card = getCard(getSize()-1);
        }

        return card;
    }

    public void remove(int index) {
        Card card = null;
        if (index < 0 || index > cardsRemaining) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        } else {
            card = getCard(index);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(getCard(i)).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Deck deck = new Deck(false);
        deck.flip();

        System.out.println(deck.getSize()); // 52
        System.out.println(deck.hasDuplicates()); // false
        System.out.println(deck.isEmpty()); // false
        System.out.println(deck);

        System.out.println("----------------------");

        Card next = deck.draw();
        System.out.println(next); // 1H
        next = deck.draw();
        System.out.println(next); // 2H
        System.out.println(deck.getSize()); // 50
        System.out.println(deck.topCard()); // 3H

        System.out.println("-------------------------");
        System.out.println(deck);
    }
}
