import java.util.ArrayList;

public class Player {
    private String name;
    private int chips;
    private Card[] hand = new Card[2];
    private int rank = 0;

    public Player(String name, int chips){
        this.name = name;
        this.chips = chips;
    }

    public void deal(Deck cards){
        hand[0] = cards.take();
        hand[1] = cards.take();
    }

    public void giveBack(Deck cards){
        cards.add(hand[0]);
        cards.add(hand[1]);
    }

    public String giveHand(){
        return hand[0].toString() + " and a " + hand[1].toString();
    }

    public String toString(){
        return "Player: " + name+ "\nChips: "+ chips + "\nCurrent Hand: " + giveHand();
    }

    public int getRank(ArrayList<Card> comCards){
        ArrayList<Card> allCards = new ArrayList<>();
        for (int i = 0; i < hand.length; i++) { // put all cards in one arraylist to check for straights and flushes
            allCards.add(hand[i]);
        }
        for (int i = 0; i < comCards.size(); i++) {
            allCards.add(comCards.get(i));
        }
        sortRank(allCards);
        if((isFlush(comCards, hand)&&isStraight(comCards, hand))&&(allCards.get(allCards.size()).getRank().equals("Ace"))){ // check if Royal Flush
            rank = 9;
            return rank;
        }
        if(isFlush(comCards, hand)&&isStraight(comCards, hand)){ // check if Straight Flush
            rank = 8;
            return rank;
        }
        if (isFlush(comCards, hand)){ // check if Flush
            rank = 5;
            return rank;
        }
        if (isStraight(comCards, hand)){ // check if Straight
            rank = 4;
            return rank;
        }
        return rank;
    }

    public static boolean isStraight(ArrayList<Card> comCards, Card[] hand){
        ArrayList<Card> allCards = new ArrayList<>();
        boolean isStraight = false;
        for (int i = 0; i < hand.length; i++) {
            allCards.add(hand[i]);
        }
        for (int i = 0; i < comCards.size(); i++) {
            allCards.add(comCards.get(i));
        }
        sortRank(allCards);
        for (int i = 0; i < allCards.size() - 4; i++) {
            if (allCards.get(i).rank + 1 == allCards.get(i + 1).rank &&
                    allCards.get(i).rank + 2 == allCards.get(i + 2).rank &&
                    allCards.get(i).rank + 3 == allCards.get(i + 3).rank &&
                    allCards.get(i).rank + 4 == allCards.get(i + 4).rank){
                isStraight = true;
            }
        }
        return isStraight;
    }

    public static void sortRank(ArrayList<Card> cards){
        for (int i = 0; i < cards.size(); i++){
            for (int j = 0; j < cards.size() - 1; j++){
                if (cards.get(j).rank > cards.get(j + 1).rank){
                    Card temp = cards.get(j);
                    cards.set(j, cards.get(j + 1));
                    cards.set(j + 1, temp);
                }
            }
        }
    }

    public static boolean isFlush(ArrayList<Card> comCards, Card[] hand){
        if (!hand[0].getSuit().equals(hand[1].getSuit())){
            return false;
        }
        for (int i = 0; i < comCards.size(); i++) {
            if (!comCards.get(i).getSuit().equals(hand[0].getSuit())){
                return false;
            }
            
        }
        return true;
    }
    /* Ranks:
    High Card: 0
    Pair: 1
    Two Pair: 2
    Three of a Kind: 3
    Straight: 4
    Flush: 5
    Full House: 6
    Four of a Kind: 7
    Straight Flush: 8
    */
}
