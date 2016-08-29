public class SuitTest {
    public static void main(String[] args) {
        System.out.println(Suit.SPADES);
        System.out.println(Suit.HEARTS);
        System.out.println(Suit.DIAMONDS);
        System.out.println(Suit.CLUBS);

        for (int i = 0; i < Suit.values().length; i++) {
            System.out.println(Suit.values()[i]);
        }
    }
}