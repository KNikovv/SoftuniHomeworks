package shapesVolume;

public class VolumeCalculator {

    static double calcCylinderVolume(Cylinder cylinder) {
        return Math.PI * cylinder.radius*cylinder.radius*cylinder.height;
    }
    static double calcCubeVolume(Cube cube){
        return Math.pow(cube.sideLength,3);
    }
    static double calcTriangPrismVolume(TriangularPrism triangularPrism){
        return 0.5d*(triangularPrism.baseSide*triangularPrism.heightFromBase*triangularPrism.length);
    }
}
