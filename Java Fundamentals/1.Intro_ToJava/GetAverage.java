package com.company;

import java.util.Scanner;

/**
 * Created by kaloy on 2/27/2016.
 */
public class GetAverage {
    public static void main(String []args){
        Scanner input = new Scanner( System.in );

        double x;
        double y;
        double z;

        System.out.print( "Enter first number: " );
        x = input.nextDouble();

        System.out.print( "Enter second number: " );
        y = input.nextDouble();

        System.out.print( "Enter third number: " );
        z = input.nextDouble();
        double result = getAverage(x,y,z);
        System.out.printf("%.2f", result);
    }
    public static double getAverage(double num1,double num2,double num3){
      double k = (num1 + num2 + num3)  /3;
        return k;
    }
}
