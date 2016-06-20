package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line;
        TreeMap<String, LinkedHashMap<String, Long>> regions = new TreeMap<>();
        while (!(line = bf.readLine()).equals("Count em all")) {
            String[] input = line.split(" -> ");
            String region = input[0];
            String meteorType = input[1];
            Long count = Long.parseLong(input[2]);

            if (!regions.containsKey(region)) {
                LinkedHashMap<String, Long> innerMap = new LinkedHashMap<>();
                innerMap.put("Green", 0L);
                innerMap.put("Red", 0L);
                innerMap.put("Black", 0L);
                regions.put(region, innerMap);
            }
            regions.get(region).put(meteorType, regions.get(region).get(meteorType) + count);
            convertToUpper(region,meteorType,regions);
        }
        for (Map.Entry<String, LinkedHashMap<String, Long>> entries : regions.entrySet()) {
            String region = entries.getKey();
            LinkedHashMap<String, Long> meteors = entries.getValue();
            for (String meteor : meteors.keySet()) {
                convertToUpper(region,meteor,regions);
            }
        }
        regions.entrySet().stream().sorted((reg1, reg2) -> {
            return Integer.compare(reg1.getKey().length(), reg2.getKey().length());
        }).sorted((reg1, reg2) -> {
            return Long.compare(reg2.getValue().get("Black"), reg1.getValue().get("Black"));
        }).forEach(reg -> {
            System.out.println(reg.getKey());
            reg.getValue().entrySet().stream().sorted((m1,m2)-> m1.getKey().compareTo(m2.getKey())).sorted((met1, met2) -> {
                return met2.getValue().compareTo(met1.getValue());
            }).forEach(meteor -> {
                System.out.printf("-> %s : %d\n", meteor.getKey(), meteor.getValue());
            });
        });
    }

    private static void convertToUpper(String region, String meteorType, TreeMap<String, LinkedHashMap<String, Long>> regions) {
        Long currentMeteorCount = regions.get(region).get(meteorType);
        String upperMeteor = meteorType.equals("Green") ? "Red" : "Black";
        if (currentMeteorCount >= 1_000_000 && !meteorType.equals("Black")) {
            regions.get(region).put(upperMeteor, regions.get(region).get(upperMeteor) +
                    currentMeteorCount / 1_000_000);
            regions.get(region).put(meteorType, currentMeteorCount % 1_000_000);
        }
    }
}
