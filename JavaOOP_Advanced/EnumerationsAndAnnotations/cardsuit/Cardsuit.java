package cardsuit;

public class Cardsuit {

    public static void main(String[] args) {

        System.out.println("Card Suits:");

        for(Suits cardSuit : Suits.values()){
            System.out.printf("Ordinal value: %d; Name value: %s\n",cardSuit.ordinal(),cardSuit.name());
        }

    }

}
enum Suits{

    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES

}