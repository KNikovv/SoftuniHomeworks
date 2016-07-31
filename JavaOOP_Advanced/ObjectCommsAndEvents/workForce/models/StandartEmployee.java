package workForce.models;

public class StandartEmployee extends EmployeeImpl {

    private static final int DEFAULT_HOURS_WORK = 40;

    public StandartEmployee(String name) {
        super(name);
        this.setHoursPerWeek(DEFAULT_HOURS_WORK);
    }
}
