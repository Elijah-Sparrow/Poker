import java.util.ArrayList;

public class DealerState {
    private final String dealer;
    private Card[] communityCards = new Card[5];
    public DealerState(){
        dealer = "dealer";
    }
    public void comCards(Deck cards){
        if (communityCards[0] == null){
            communityCards[0] = cards.take();
            communityCards[1] = cards.take();
            communityCards[2] = cards.take();
        }
        else if (communityCards[3] == null){
            communityCards[3] = cards.take();
        }
        else if (communityCards[4] == null){
            communityCards[4] = cards.take();
        }
    }

    public void giveBack(Deck cards){
        for (int i = 0; i < communityCards.length; i++){
            if (communityCards[i] != null){
                cards.add(communityCards[i]);
            }
        }
    }

    public ArrayList<Card> getCommunityCards(){
        ArrayList<Card> comCards = new ArrayList<>();
        for (int i = 0; i < communityCards.length; i++){
            if (communityCards[i] != null){
                comCards.add(communityCards[i]);
            }
        }
        return comCards;
    }

    public String toString(){
        String s = "Dealer: " + dealer + "\nCommunity Cards: ";
        for (int i = 0; i < communityCards.length; i++){
            if (communityCards[i] != null){
                s += communityCards[i].toString() + ", ";
            }
        }
        return s;
    }
}
