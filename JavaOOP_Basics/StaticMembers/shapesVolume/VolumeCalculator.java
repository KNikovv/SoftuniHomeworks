package shapesVolume;

public class VolumeCalculator {

    static double calcCylinderVolume(double radius, double height) {
        return Math.PI * radius * radius * height;
    }
    static double calcCubeVolume(double sideLength){
        return Math.pow(sideLength,3);
    }
    static double calcTriangPrismVolume(double length, double width ,double height){
        return 0.5d*(length*width*height);
    }
}
