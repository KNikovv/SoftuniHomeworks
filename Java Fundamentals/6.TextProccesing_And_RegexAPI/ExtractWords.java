package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaloy on 2/29/2016.
 */
public class ExtractWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern extract = Pattern.compile("([A-Za-z]{2,})");
        Matcher match = extract.matcher((s));
        while(match.find()){
            System.out.print(match.group()+ " ");
        }
    }
}
