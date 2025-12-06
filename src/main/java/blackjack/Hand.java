import java.util.List;
import java.util.ArrayList;

/**
 * Each Hand represents cards in front of a player 
 * or the dealer for a single round
 */

public class Hand {

    private List<Card> hand;
    
    public Hand() {
        this.hand = new ArrayList<>();

    }

    public int size() {
        return hand.size();
    }

    public void clear() {
        hand.clear();
    }

    public boolean isEmpty() {
        return hand.isEmpty();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void push(Card card) {
        if (card != null) {
            hand.add(card);
        }
    }

    // public int value() {
    //     int sumTotal = 0;

    //     for (Card c: hand) {
    //         sumTotal += c.getRank().getValue();
    //     }
    // }




}
