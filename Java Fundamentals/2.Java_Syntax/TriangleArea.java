package com.company;

import java.util.Scanner;

/**
 * Created by kaloy on 2/28/2016.
 */
public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ax = input.nextInt();
        int ay = input.nextInt();
        int bx = input.nextInt();
        int by = input.nextInt();
        int cx = input.nextInt();
        int cy = input.nextInt();

        int area = Math.abs((ax*(by - cy)+(bx*(cy - ay)) + (cx*(ay-by)))/2);
        System.out.print(area);

    }
}
