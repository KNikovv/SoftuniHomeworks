import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        LinkedHashMap<String , LinkedHashMap<String, Long>> venues = new LinkedHashMap<>();
        Pattern pat = Pattern.compile("(.*)\\s@(.*)\\s(\\d+)\\s(\\d+)");
        while(!(input = sc.nextLine()).equals("End")){
            Matcher match = pat.matcher(input);
            if(match.find()){
                String singer = match.group(1);
                String venue = match.group(2);
                long tPrice = Long.parseLong(match.group(3));
                long tCount = Long.parseLong(match.group(4));
                long moneyMade = tPrice*tCount;
                if(!venues.containsKey(venue)){
                    venues.put(venue,new LinkedHashMap<>());
                }
                if(!venues.get(venue).containsKey(singer)){
                    venues.get(venue).put(singer,0L);
                }
                venues.get(venue).put(singer,venues.get(venue).get(singer)+moneyMade);
            }
        }
        venues.entrySet().stream().forEach(venue -> {
            System.out.println(venue.getKey());
            venue.getValue().entrySet().stream()
                    .sorted((s1,s2)-> s2.getValue().compareTo(s1.getValue()))
                    .forEach(singer -> {
                        System.out.format("#  %s -> %d\n",singer.getKey(),singer.getValue());
                    });
        });
    }
}
