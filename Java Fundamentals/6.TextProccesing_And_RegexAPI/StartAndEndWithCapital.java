package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaloy on 2/29/2016.
 */
public class StartAndEndWithCapital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern extract = Pattern.compile("\\b[A-Z][a-zA-Z]*[A-Z]\\b");
        Matcher matching = extract.matcher(s);


        while(matching.find()){
            System.out.print(matching.group()+ " ");
        }
    }
}
