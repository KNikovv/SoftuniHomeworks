import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinersTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Long> map = new LinkedHashMap<>();
        String input = "";
        int index = 1;
        String previousResource = "";
        while(!(input = sc.nextLine()).equals("stop")){
            if(index%2==1){
                if(!map.containsKey(input)){
                    map.put(input,0L);
                }
                previousResource = input;
            }else{
                long quantity = Long.parseLong(input);
                map.put(previousResource,map.get(previousResource)+quantity);
            }
            index++;
        }
        map.entrySet().stream().forEach(resource ->{
            System.out.format("%s -> %d\n",resource.getKey(),resource.getValue());
        });
    }
}
