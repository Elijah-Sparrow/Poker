import java.util.ArrayList; // Import the ArrayList class
import java.util.Collections;

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    public Deck(){
        Card get;
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                get = new Card(i,j);
                deck.add(get);
            }
        }
    }

    public void add(Card give){
        deck.add(give);
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < deck.size(); i++) {
            s += "\n"+deck.get(i);
        }
        return s;
    }

    public int size(){
        return deck.size();
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card take(){
        return deck.remove(0);
    }

    
}
