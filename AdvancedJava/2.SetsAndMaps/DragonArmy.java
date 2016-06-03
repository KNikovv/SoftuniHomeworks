import java.util.*;

/**
 * Created by kaloy on 3/20/2016.
 */
public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragonMap = new LinkedHashMap<>();

        while (lines > 0) {
            String[] line = scan.nextLine().split(" ");
            String type = line[0];
            String name = line[1];
            int damage = !line[2].equals("null") ? Integer.parseInt(line[2]) : 45;
            int health = !line[3].equals("null") ? Integer.parseInt(line[3]) : 250;
            int armor = !line[4].equals("null") ? Integer.parseInt(line[4]) : 10;

            ArrayList<Integer> stats = new ArrayList<>();
            stats.add(damage);
            stats.add(health);
            stats.add(armor);

            if (!dragonMap.containsKey(type)) {
                dragonMap.put(type, new TreeMap<>());
            }

            dragonMap.get(type).put(name, stats);

            lines--;
        }
        Set<String> dragonTypes = dragonMap.keySet();

        for (String type : dragonTypes) {
            Double sumDmg=0d;
            Double sumHealth=0d;
            Double sumArmor=0d;
            TreeMap<String, ArrayList<Integer>> names = dragonMap.get(type);
            Set<String> nameSet = names.keySet();
            for(String name : nameSet){
                ArrayList<Integer> currentDragon = names.get(name);
                sumDmg += currentDragon.get(0);
                sumHealth += currentDragon.get(1);
                sumArmor += currentDragon.get(2);
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",type,sumDmg/names.size(),
                    sumHealth/names.size(),sumArmor/names.size());
            for(String name : nameSet){
                ArrayList<Integer> currentDragon = names.get(name);
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",name,currentDragon.get(0),currentDragon.get(1)
                        ,currentDragon.get(2));
            }
        }
    }

}