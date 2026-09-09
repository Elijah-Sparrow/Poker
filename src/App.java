public class App {
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!");
        Deck test = new Deck();
        test.shuffle();
        Player me = new Player("Elijah", 0);
        me.deal(test);
        System.out.println(me.toString());
    }
}
