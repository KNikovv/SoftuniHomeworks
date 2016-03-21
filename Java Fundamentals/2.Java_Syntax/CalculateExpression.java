package com.company;

import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double firstFormula = Math.pow((a*a + b*b)/(a*a - b*b),(a+b+c)/Math.sqrt(c));
        double secondFormula = Math.pow((a*a + b*b -(c*c*c)),a-b);

        double avgFormulas = (firstFormula+secondFormula)/2;
        double numbers = (a + b + c)/3;

        System.out.printf("F1 result: %.2f;  F2 result: %.2f;  Diff: %.2f",firstFormula,secondFormula,Math.abs(avgFormulas-numbers));
    }
}
