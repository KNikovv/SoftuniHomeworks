package drawingTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String figureType = bf.readLine();
        Figure figure;
        int sideA;
        int sideB;
        if(figureType.equals("Square")){
            sideA = Integer.parseInt(bf.readLine());
            figure = new Square(sideA);
        }else{
            sideA = Integer.parseInt(bf.readLine());
            sideB = Integer.parseInt(bf.readLine());
            figure = new Rectangle(sideA,sideB);
        }
        CorDraw corDraw = new CorDraw(figure);
        corDraw.drawFigure();
    }
}

class CorDraw {

    Figure figure;

     CorDraw(Figure figure) {
        this.figure = figure;
    }

    public void drawFigure() {
        int verticalLines = this.figure.getSideB();
        int horizontalLines = this.figure.getSideA()+2;
        for (int i = 0; i < verticalLines; i++) {
            for (int p = 0; p < horizontalLines; p++) {
                    if(p==0||p== horizontalLines-1){
                        System.out.print("|");
                        continue;
                    }
                    if(i==0||i== verticalLines-1){
                        System.out.print("-");
                        continue;
                    }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

abstract class Figure {

    private int sideA;
    private int sideB;

    Figure(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }
}

class Square extends Figure {

    Square(int sideA) {
        super(sideA, sideA);
    }
}

class Rectangle extends Figure {

    Rectangle(int sideA, int sideB) {
        super(sideA, sideB);
    }
}