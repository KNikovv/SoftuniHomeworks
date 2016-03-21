package com.company;

import java.util.Scanner;

public class HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();
        for(int i = 1;i<=20;i++){
            for(int j=1;j<=20;j++){
                if(i+j==target){
                    System.out.printf("%d + %d = %d",i,j,target);
                    System.out.println();
                }
                else if(i-j==target){
                    System.out.printf("%d - %d = %d",i,j,target);
                    System.out.println();
                }
            }
        }
    }
}
