import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line ;
        int largeArrows = 0;
        int mediumArrows = 0;
        int smallArrows = 0;
        Pattern pattern = Pattern.compile("(>-{5}>)|(>>-{5}>)|(>>>-{5}>>)");
        for(int i = 0 ;i<4;i++){
            line = bf.readLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                if(matcher.group(1)!=null){
                    smallArrows++;
                }else if(matcher.group(2)!=null){
                    mediumArrows++;
                }else{
                    largeArrows++;
                }
            }
        }
        String concatArrows = String.valueOf(smallArrows) + String.valueOf(mediumArrows) + String.valueOf(largeArrows);

        String initialbinaryRepresantion = Integer.toBinaryString(Integer.parseInt(concatArrows));
        String reverseInitialBinary = new StringBuilder(initialbinaryRepresantion).reverse().toString();
        String finalBinary = initialbinaryRepresantion + reverseInitialBinary;

        int finalBinaryToDecimal = Integer.parseInt(finalBinary,2);
        System.out.println(finalBinaryToDecimal);
    }
}
