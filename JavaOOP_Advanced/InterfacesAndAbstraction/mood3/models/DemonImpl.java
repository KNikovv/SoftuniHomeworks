package mood3.models;

import mood3.interfaces.Demon;

public class DemonImpl<Double> extends Character implements Demon {

    public DemonImpl(String userName, int level, Number specialPoints) {
        super(userName, level, specialPoints);
        this.setPoints();
    }

    @Override
    public Double getEnergy() {
        return (Double) this.specialPoints;
    }

    @Override
    public void setPoints() {
        this.specialPoints = this.getLevel() * this.specialPoints.doubleValue();
    }

    @Override
    public String toString() {
        return super.toString() + this.getEnergy();
    }
}
