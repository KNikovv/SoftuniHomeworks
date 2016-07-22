package deckofcards;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        for (Suit suit : Suit.values()) {

            for (Rank rank : Rank.values()) {
                System.out.printf("%s of %s%n", rank.name(), suit.name());
            }
        }
    }
}
