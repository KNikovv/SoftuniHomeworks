import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        Pattern pat = Pattern.compile("(.+)-(.+)");
        HashMap<String,String > map = new HashMap<>();
        while(!(input = sc.nextLine()).equals("search")){
            Matcher matcher = pat.matcher(input);
            if(matcher.find()) {
                map.put(matcher.group(1), matcher.group(2));
            }
        }
        while(!(input= sc.nextLine()).equals("stop")){
            if(map.containsKey(input)){
                System.out.format("%s -> %s\n",input,map.get(input));
            }else{
                System.out.format("Contact %s does not exist.\n",input);
            }
        }
    }
}