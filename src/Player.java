public class Player {
    private String name;
    private int chips;
    private Card[] hand = new Card[2];
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

}
