package catLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> cats = new ArrayList<>();
        String line;

        while (!(line = bf.readLine()).equals("End")) {
            String[] catInput = line.split("\\s+");
            String catBreed = catInput[0];
            String catName = catInput[1];
            String catCharacteristic = (catInput[2]);
            Cat cat = null;
            switch (catBreed) {
                case "Cymric":
                    cat = new Cymric(catName, catCharacteristic);
                    break;
                case "Siamese":
                    cat = new Siamese(catName, catCharacteristic);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire( catName, catCharacteristic);
                    break;
            }
            cats.add(cat);
        }

        String catWanted = bf.readLine();
        for(Cat cat : cats){
            if(cat.getName().equals(catWanted)){
                System.out.println(cat);
            }
        }
    }
}
