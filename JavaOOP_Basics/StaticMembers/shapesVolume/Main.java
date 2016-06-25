package shapesVolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = bf.readLine()).equals("End")) {
            String[] input = line.split("\\s+");
            switch (input.length) {
                case 2:
                    double side = Double.parseDouble(input[1]);
                    System.out.printf("%.3f\n", VolumeCalculator.calcCubeVolume(side));
                    break;
                case 3:
                    double radius = Double.parseDouble(input[1]);
                    double height = Double.parseDouble(input[2]);
                    System.out.printf("%.3f\n", VolumeCalculator.calcCylinderVolume(radius, height));
                    break;
                case 4:
                    double baseSide = Double.parseDouble(input[1]);
                    double heightt = Double.parseDouble(input[2]);
                    double length = Double.parseDouble(input[3]);
                    System.out.printf("%.3f\n", VolumeCalculator.calcTriangPrismVolume(baseSide, heightt, length));
                    break;
            }
        }
    }
}
