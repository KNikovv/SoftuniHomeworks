import java.util.*;
import java.util.stream.Stream;

/**
 * Created by kaloy on 3/16/2016.
 */
public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split(" ");
        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("motes", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();
        String item = "";
        while (true) {
            for (int i = 0; i < line.length; i += 2) {
                int count = Integer.parseInt(line[i]);
                String material = line[i + 1].toLowerCase();
                if (material.equals("motes") || material.equals("fragments") ||
                        material.equals("shards")) {
                    keyMaterials.put(material, keyMaterials.get(material) + count);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        item = material;
                        switch(item){
                            case "motes": item = "Dragonwrath";break;
                            case "fragments": item="Valanyr";break;
                            case "shards": item ="Shadowmourne";break;
                        }
                        break;
                    }
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, 0);
                    }
                    junkMaterials.put(material,junkMaterials.get(material) +count);
                }
            }if(item.length()>0){
                break;
            }
            line = scan.nextLine().split(" ");
            if (line.equals(null)) {
                break;
            }
        }
        System.out.println(item + " obtained!");
        keyMaterials.entrySet().stream().sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        junkMaterials.entrySet().stream().forEach(e -> System.out.println(e.getKey()+ ": " + e.getValue()));
    }
}