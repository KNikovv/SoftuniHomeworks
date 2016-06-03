import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String input = sc.nextLine();
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(int i = 0 ;i<input.length();i++){
            char current = input.charAt(i);
            if(!map.containsKey(current)){
                map.put(current,0);
            }
            map.put(current,map.get(current)+1);
        }
        map.entrySet().stream().forEach(ch -> {
            System.out.format("%s: %d time/s\n",ch.getKey(),ch.getValue());
        });
    }
}