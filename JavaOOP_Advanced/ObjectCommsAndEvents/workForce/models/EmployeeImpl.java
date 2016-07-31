package workForce.models;

import workForce.interfaces.Employee;

public class EmployeeImpl implements Employee {

    private String name;
    private int hoursPerWeek;

    public EmployeeImpl(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHoursPerWeek() {
        return this.hoursPerWeek;
    }

    protected void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
}
