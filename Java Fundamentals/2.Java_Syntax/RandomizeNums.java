package com.company;

import java.util.*;


public class RandomizeNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int minimum = Math.min(a,b);
        int maximum = Math.max(a,b);
        List<Integer> list = new ArrayList<>();
        for (int i = minimum; i <=maximum ; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int num:list
             ) {
            System.out.print(num + " ");

        }
    }
    }

