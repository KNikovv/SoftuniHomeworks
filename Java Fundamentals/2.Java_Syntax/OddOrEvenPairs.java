package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddOrEvenPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] splittedinput = input.split(" ");
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < splittedinput.length; i+=2) {
            int currentnum = Integer.parseInt(splittedinput[i]);
            int nextnum = Integer.parseInt(splittedinput[i+1]);
            if(splittedinput.length%2==1){
                System.out.println("Invalid length");
                break;
            }
            if((currentnum%2==0&&nextnum%2==0)||(currentnum%2==1&&nextnum%2==1)){
                if(currentnum%2==0){
                    System.out.printf("%d %d -> both are even",currentnum,nextnum);
                }
                else{
                    System.out.printf("%d %d -> both are odd",currentnum,nextnum);
                }
            }
            else{
                System.out.printf("%d %d -> different",currentnum,nextnum);
            }
            System.out.println();
        }


    }
    }

