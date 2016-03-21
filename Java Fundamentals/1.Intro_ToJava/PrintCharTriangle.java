package com.company;

import java.util.Scanner;

public class PrintCharTriangle {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for(int i = 1; i <= number; i++) {
            char c = 'a';

            for(int j = 1; j <= i; j++) {
                System.out.print(c + " ");
                c++;
            }

            System.out.println();
        }

        for(int i = number; i > 0; i--) {
            char c = 'a';

            for(int j = 1; j < i; ++j) {
                System.out.print(c + " ");
                ++c;
            }

            System.out.println();
        }

    }
}
