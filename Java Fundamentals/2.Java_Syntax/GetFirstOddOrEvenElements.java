package com.company;

import java.util.Scanner;

/**
 * Created by kaloy on 2/29/2016.
 */
public class GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String command = sc.nextLine();

        String[] commandSplitted = command.split("\\s+");
        int elementsNeeded = Integer.parseInt(commandSplitted[1]);
        String[] inputSplitted = input.split("\\s+");
        getOddOrEven(inputSplitted,commandSplitted,elementsNeeded);
    }
    public static void getOddOrEven(String[] inputSplitted,String[] commandSplitted,int elementsNeeded){
        for(int i =0;i<inputSplitted.length;i++){
            int currentNumber = Integer.parseInt(inputSplitted[i]);
            if(elementsNeeded<=0){
                break;
            }
            if("odd".equals(commandSplitted[2])){
                if(currentNumber%2==1){
                    System.out.printf("%d ",currentNumber);
                    elementsNeeded--;
                }
            }
            else if("even".equals(commandSplitted[2])){
                if(currentNumber%2==0){
                    System.out.printf("%d ",currentNumber);
                    elementsNeeded--;
                }
            }
        }

    }
}
