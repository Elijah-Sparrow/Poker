import java.util.ArrayList; // Import the ArrayList class

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    public Deck(){
        Card get = new Card(1,1);
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                deck.add(get);
                get = new Card(i,j);

            }
        }
        deck.add(new Card(13,3));
    }

    public void add(Card give){
        deck.add(give);
    }

    public String toString(){
        String s = "";
        for (int i = 1; i < deck.size(); i++) {
            s += "\n"+deck.get(i);
        }
        return s;
    }
    
    public void shuffle(){
        for (int i = 0; i < 200; i++) {
            int change = (int) (Math.random()*53);
            Card move = deck.remove(change);
            deck.add(move);
        }
    }

    public Card take(){
        return deck.remove(0);
    }

    
}
