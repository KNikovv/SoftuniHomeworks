import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int index = 0;
        String previousName = "";
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        Pattern pat = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.([a-zA-Z]+)");
        while(!(input.equals("stop"))){
            if(index%2==0){
                if(!map.containsKey(input)){
                    map.put(input,"");
                    previousName = input;
                }
            }else{
                Matcher matcher = pat.matcher(input);
                if(matcher.find()){
                    String domain = matcher.group(1);
                    if(!domain.equals("uk")&&!domain.equals("us")){
                        map.put(previousName,matcher.group());
                    }else{
                        map.remove(previousName);
                    }
                }
            }
            index++;
            input = sc.nextLine();
        }
        map.entrySet().stream().forEach(name ->{
            System.out.format("%s -> %s\n",name.getKey(),name.getValue());
        });
    }
}