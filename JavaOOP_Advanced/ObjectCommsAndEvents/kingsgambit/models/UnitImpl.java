package kingsgambit.models;

import kingsgambit.interfaces.king.King;
import kingsgambit.interfaces.unit.Unit;

public abstract class UnitImpl implements Unit {

    private String name;
    private int healthPoints;
    private King king;

    public UnitImpl(String name, King king) {
        this.setName(name);
        this.setKing(king);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    protected int getHealthPoints() {
        return this.healthPoints;
    }

    private void setKing(King king) {
        this.king = king;
    }

    @Override
    public void handleKill() {
        this.setHealthPoints(this.getHealthPoints() - 1);
        if (this.getHealthPoints() == 0) {
            this.king.removeDeadUnit(this.getName());
        }
    }
}
