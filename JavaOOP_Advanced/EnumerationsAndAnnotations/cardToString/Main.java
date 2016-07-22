package cardToString;

import cardToString.enums.Rank;
import cardToString.enums.Suit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String type = buffReader.readLine();
        Class<Rank> cl1 = Rank.class;
        Class<Suit> cl2 = Suit.class;
        EnumInfo annotation;
        annotation = type.equals("Rank") ?
                cl1.getAnnotation(EnumInfo.class) :
                cl2.getAnnotation(EnumInfo.class);

        System.out.printf("Type = %s, Description = %s",annotation.Type(),annotation.Description());
    }
}
