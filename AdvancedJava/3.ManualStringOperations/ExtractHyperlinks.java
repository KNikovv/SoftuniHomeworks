
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Pattern pat = Pattern.compile("<a\\s*([^>]\\s*)*?href\\s*=\\s*(?:'([^']*)'|\"([^\"]*)\"|([^\\s>]+))[^>]*>");
        StringBuilder sb = new StringBuilder();
        while(!(input = scan.nextLine()).equals("END")){
            sb.append(input);
        }
        Matcher match = pat.matcher(sb.toString());
        while(match.find()){
            if(match.group(3)!=null){
                System.out.println(match.group(3));
            }else if(match.group(4)!=null){
                System.out.println(match.group(4));
            }else{
                System.out.println(match.group(2));
            }
        }
    }
}