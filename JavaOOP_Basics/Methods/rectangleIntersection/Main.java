package rectangleIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer[] input = Arrays.stream(bf.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer Nrectangles = input[0];
        Integer NpairsOfIds = input[1];
        HashMap<String, Rectangle> rectangleMap = new HashMap<>();
        for (int i = 0; i < Nrectangles; i++) {
            String[] currentRecLine = bf.readLine().split("\\s+");
            String id = currentRecLine[0];
            double width = Double.parseDouble(currentRecLine[1]);
            double height = Double.parseDouble(currentRecLine[2]);
            double xCoord = Double.parseDouble(currentRecLine[3]);
            double yCoord = Double.parseDouble(currentRecLine[4]);
            Rectangle rectangle = new Rectangle(id, width, height, xCoord, yCoord);
            rectangleMap.put(id, rectangle);
        }
        for (int i = 0; i < NpairsOfIds; i++) {
            String[] idsToIntersect = bf.readLine().split("\\s+");
            String firstId = idsToIntersect[0];
            String secondId = idsToIntersect[1];

            Rectangle pesho = rectangleMap.get(firstId);
            Rectangle gosho = rectangleMap.get(secondId);
            System.out.println(pesho.intersects(gosho));
        }
    }
}

class Rectangle {

    private String id;
    private double width;
    private double height;
    private double Xcoord;
    private double Ycoord;

    Rectangle(String id, double width, double height, double Xcoord, double Ycoord) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.Xcoord = Xcoord;
        this.Ycoord = Ycoord;
    }

    public String getId() {
        return this.id;
    }

    public boolean intersects(Rectangle other) {
        if (this.Xcoord + this.width < other.Xcoord || other.Xcoord + other.width < this.Xcoord ||
                this.Ycoord + this.height < other.Ycoord || other.Ycoord + other.height < this.Ycoord) {
            return false;
        } else {
            return true;
        }
    }
}