package rawData;

import java.util.ArrayList;

public class Tire {
    private int tireAge;
    private double tirePressure;
    public Tire(double tirePressure, int tireAge ) {
        this.tireAge = tireAge;
        this.tirePressure = tirePressure;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(double tirePressure) {
        this.tirePressure = tirePressure;
    }

}
