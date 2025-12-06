/**
 * Standard playing card
 */

public class Card {
    
    public enum Suit {
        HEARTS("red"),
        DIAMONDS("red"),
        CLUBS("black"),
        SPADES("black");

        private final String color;

        private Suit(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    public enum Rank {
        ACE(11),
        TWO(2), THREE(3),
        FOUR(4), FIVE(5), 
        SIX(6), SEVEN(7), 
        EIGHT(8), NINE(9), 
        TEN(10), JACK(10), 
        QUEEN(10), KING(10);
        

        private final int value;

        private Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private final Suit suit;
    private final Rank rank;
    private boolean faceUp;

    public Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
        faceUp = false;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        faceUp = !faceUp;
    }

    /**
     * Indicates whether some other object is equal to this one.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;

        Card card = (Card) other;
        return this.getRank() == card.getRank() &&
        this.getSuit() == card.getSuit();
    }

    @Override
    public String toString() {
        if (faceUp) {
            return rank.getValue() + suit.name().substring(0, 1);
        } else {
            return "XX";
        }
    }

    public static void main(String[] args) {
        Card c = new Card(Rank.ACE, Suit.SPADES);
        c.flip();
        System.out.println(c);
    }
}
