package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.jar.Pack200;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        String line;
        while (!(line = bf.readLine()).equals("Over!")) {
            int length = Integer.parseInt(bf.readLine());
            String regex = "^([0-9]+)([a-zA-Z]" + "{1," + length + "})" + "([^a-zA-Z]*)$";
            Pattern pat = Pattern.compile(regex);
            Matcher matcher = pat.matcher(line);
            StringBuilder sb = new StringBuilder();
            while (matcher.find()) {
                String middle = matcher.group(2);
                sb.append(middle + " == ");
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        int index = line.charAt(i) - 48;
                        if (index < middle.length()) {
                            sb.append(middle.charAt(index));
                        } else {
                            sb.append(" ");
                        }
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}