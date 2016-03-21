package com.company;

import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstN = input.nextInt();
        float secondN =input.nextFloat();
        float thirdN =input.nextFloat();
        String aBinary = Integer.toString(firstN, 2);
        System.out.printf("|%-10x|%s|%10.2f|%-10.3f|",firstN,("0000000000" + aBinary).substring(aBinary.length()),secondN,thirdN);
    }
}
