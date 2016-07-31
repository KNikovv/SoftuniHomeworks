package kingsgambit.models;

import kingsgambit.interfaces.king.King;
import kingsgambit.interfaces.unit.Unit;

import java.util.Collection;
import java.util.LinkedList;

public class KingImpl implements King {

    private String name;
    private Collection<Unit> unitsUnderCommand;

    public KingImpl(String name) {
        this.setName(name);
        this.unitsUnderCommand = new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public void respondToAttack() {
        System.out.printf("King %s is under attack!\n", this.getName());
        for (Unit unit : this.unitsUnderCommand) {
            unit.handleRespondToAttack();
        }
    }

    public void respondToKill(String name) {
        for (Unit unit : this.unitsUnderCommand) {
            if (unit.getName().equals(name)) {
                unit.handleKill();
                break;
            }
        }
    }

    @Override
    public void addUnits(Collection<Unit> units) {
        this.unitsUnderCommand.addAll(units);
    }

    @Override
    public void removeDeadUnit(String unitName) {
        this.unitsUnderCommand.removeIf(e -> e.getName().equals(unitName));
    }
}
