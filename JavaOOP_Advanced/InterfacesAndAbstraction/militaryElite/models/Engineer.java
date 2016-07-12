package militaryElite.models;

import militaryElite.interfaces.IEngineer;
import militaryElite.interfaces.IRepair;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {

    private List<IRepair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public List<IRepair> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepair(String partName, int hoursWorked) {
        IRepair repair = new Repair(partName, hoursWorked);
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder repairsToString = new StringBuilder();
        repairsToString.append("Repairs:\n");
        this.repairs.forEach(repairsToString::append);
        return super.toString() + repairsToString;
    }
}
