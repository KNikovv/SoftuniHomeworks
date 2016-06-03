import java.util.*;

/**
 * Created by kaloy on 3/19/2016.
 */
public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        while(!n.equals("end")){
            String[] inputSplit = n.split(" ");
            String ip = inputSplit[0].substring(3,inputSplit[0].length());
            String user = inputSplit[2].substring(5,inputSplit[2].length());
            int count =0;
            if(!logs.containsKey(user)){
                logs.put(user, new LinkedHashMap<>());
            }
            if(logs.get(user).containsKey(ip)){
                logs.get(user).put(ip,logs.get(user).get(ip) + 1);
            }else{
                logs.get(user).put(ip,++count);
            }

            n = scan.nextLine();
        }
        Set<String> users = logs.keySet();

        for(String user : users){
            System.out.println(user + ": " );
            LinkedHashMap<String, Integer> ips = logs.get(user);
            Set<String> ipSet = ips.keySet();
            int count =0;
            for(String ip : ipSet){
                String dotorComma = count==ipSet.size()-1 ? "." : ", ";
                System.out.print(ip  + " => " + ips.get(ip) + dotorComma);
                count++;
            }
            System.out.println();
        }
    }
}