package com.company;

import java.util.Scanner;

/**
 * Created by kaloy on 2/29/2016.
 */
public class CharMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] splitStr = input.split("\\s+");

        String firstWord;
        String secondWord;
        if(splitStr[0].length()>splitStr[1].length()){
            firstWord=splitStr[0];
            secondWord =splitStr[1];
        }else{
            firstWord = splitStr[1];
            secondWord = splitStr[0];
        }
        long sum = GetSum(firstWord,secondWord);
        System.out.println(sum);
    }
    public static long GetSum(String firstWord, String secondWord) {
        long sum=0;
        for(int i=0;i<firstWord.length();i++){
            if(i<secondWord.length()){
                sum += (firstWord.charAt(i)*(secondWord.charAt(i)));
            }
            else{
                sum += (firstWord.charAt(i));
            }
        }
            return sum;
    }
}
