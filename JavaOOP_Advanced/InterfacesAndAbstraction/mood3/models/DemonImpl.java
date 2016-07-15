package mood3.models;

import mood3.interfaces.Demon;

public class DemonImpl extends Character<String,Double> implements Demon {

    public DemonImpl(String userName, int level, Double specialPoints) {
        super(userName, level, specialPoints);
        this.setPoints();
    }

    @Override
    public Double getEnergy() {
        return (Double) this.specialPoints;
    }


    private void setPoints() {
        this.specialPoints = this.getLevel() * this.specialPoints;
    }

    @Override
    public String toString() {
        return super.toString() + this.getEnergy();
    }
}
