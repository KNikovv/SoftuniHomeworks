import java.util.*;

/**
 * Created by kaloy on 3/18/2016.
 */
public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        Map<String, HashMap<String,Integer>> logs = new TreeMap<>();
        while(lines>0){
            String [] line = scan.nextLine().split(" ");
            String ip = line[0];
            String name = line[1];
            int duration = Integer.parseInt(line[2]);

            if(!logs.containsKey(name)){
                logs.put(name, new HashMap<>());
            }
            if(!logs.get(name).containsKey(ip)){
                logs.get(name).put(ip,duration);
            }else{
                logs.get(name).put(ip,logs.get(name).get(ip)+duration);
            }
            lines--;
        }
        Set<String> names = logs.keySet();

        for (String name : names) {
            System.out.print(name + ": ");
            TreeMap<String,Integer> uniqueLogs = new TreeMap<>(logs.get(name));
            Set<String> ips = uniqueLogs.keySet();
            int totalduration =0;
            for(String ip : ips){
                totalduration += uniqueLogs.get(ip);
            }
            System.out.print(totalduration + " ");
            System.out.println(ips);
        }
    }
}