package workForce.models;

public class PartTimeEmployee extends EmployeeImpl {

    private static final int DEFAULT_HOURS_WORK = 20;

    public PartTimeEmployee(String name) {
        super(name);
        this.setHoursPerWeek(DEFAULT_HOURS_WORK);
    }
}
