package mood3.models;

import mood3.interfaces.Archangel;

public class ArchangelImpl extends Character<String,Integer> implements Archangel {

    public ArchangelImpl(String userName, int level, Integer specialPoints) {
        super(userName, level, specialPoints);
        this.setPoints();
    }

    @Override
    public Integer getMana() {
        return (Integer) this.specialPoints;
    }


    private void setPoints() {
        this.specialPoints = this.getLevel() * this.specialPoints;
    }

    @Override
    public String toString() {
        return super.toString() + this.getMana();
    }
}
