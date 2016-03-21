package com.company;

import java.util.Scanner;

public class DecimalToBase7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long decimalNum = input.nextLong();
        String baseSeven = "";
        while(decimalNum>0){
          baseSeven+=decimalNum%7;
            decimalNum/=7;
        }
        String reverse = new StringBuffer(baseSeven).reverse().toString();
        System.out.println(reverse);
    }
}
