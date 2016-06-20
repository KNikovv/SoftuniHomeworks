package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String line;
        BigInteger sum = BigInteger.ZERO;
        int freeDimensions = (int)Math.pow(n,3);
        while (!(line = bf.readLine()).equals("Analyze")) {
            Integer[] arr = Arrays.stream(line.split("\\s")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer d1 = arr[0];
            Integer d2 = arr[1];
            Integer d3 = arr[2];
            Integer num = arr[3];
            if ((d1 < n && d2 < n && d3 < n) && (d1 >= 0 && d2 >= 0 && d3 >= 0)) {
                sum = sum.add(BigInteger.valueOf(num));
                if (num > 0) {
                    freeDimensions--;
                }
            }
        }
        System.out.println(sum);
        System.out.println(freeDimensions);
    }
}
