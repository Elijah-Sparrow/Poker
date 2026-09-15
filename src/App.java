public class App {
    public static void main(String[] args) throws Exception {
        Deck test = new Deck();
        System.out.println(test.size());
        DealerState dealer = new DealerState();
        System.out.println("\n"+test.toString());
        //test.shuffle();
        //Player me = new Player("Elijah", 0);
        //me.deal(test);
        //dealer.comCards(test);
        //dealer.comCards(test);
        //dealer.comCards(test);
        //System.out.println(me.toString());
        //System.out.println("\n" + dealer.toString());
        //System.out.println(me.getRank(dealer.getCommunityCards()));
    }
}
