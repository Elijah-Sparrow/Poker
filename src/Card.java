public class Card {
    public static final String[] RANKS = {null, "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    int rank;
    int suit;

    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String toString(){
        String s = RANKS[this.rank] + " of " + SUITS[this.suit];
        return s;
    }

    public String getRank(){
        return RANKS[this.rank];
    }

    public String getSuit(){
        return SUITS[this.suit];
    }
}
