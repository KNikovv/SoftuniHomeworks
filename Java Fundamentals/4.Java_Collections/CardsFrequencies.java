import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kaloy on 3/10/2016.
 */
public class CardsFrequencies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] cards = scan.nextLine().split("\\W+");
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i <cards.length ; i++) {
            String card = cards[i];
            double countCard = 1;
            if(resultList.contains(card)){
                continue;
            }
            resultList.add(card);
            for(int j=i+1;j<cards.length;j++){
                if(i==cards.length-1){
                    break;
                }
                String nextcard = cards[j];
                if(card.equals(nextcard)){
                    countCard++;
                }
            }
            double frequency = (countCard/cards.length)*100;
            System.out.printf("%s -> %.2f%%",card,frequency);
            System.out.println();
        }
    }
}
