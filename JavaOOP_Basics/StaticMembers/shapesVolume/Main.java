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
            double height;
            double result = 0.0;
            switch (input.length) {
                case 2:
                    double side = Double.parseDouble(input[1]);
                    Cube cube = new Cube(side);
                    result = VolumeCalculator.calcCubeVolume(cube);
                    break;
                case 3:
                    double radius = Double.parseDouble(input[1]);
                     height = Double.parseDouble(input[2]);
                    Cylinder cylinder = new Cylinder(radius,height);
                    result = VolumeCalculator.calcCylinderVolume(cylinder);
                    break;
                case 4:
                    double baseSide = Double.parseDouble(input[1]);
                    height = Double.parseDouble(input[2]);
                    double length = Double.parseDouble(input[3]);
                    TriangularPrism triangularPrism = new TriangularPrism(baseSide,height,length);
                    result = VolumeCalculator.calcTriangPrismVolume(triangularPrism);
                    break;
            }
            System.out.printf("%.3f\n",result);
        }
    }
}
