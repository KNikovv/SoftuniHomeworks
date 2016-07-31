package workForce.models;

import workForce.JobDoneEvent;
import workForce.interfaces.Employee;
import workForce.interfaces.Job;
import workForce.interfaces.JobDone;

public class JobImpl implements Job {

    private String name;
    private Employee employee;
    private int hoursRequired;
    private boolean isDone;

    public JobImpl(String name, Employee employee, int hoursRequired) {
        this.setName(name);
        this.setEmployee(employee);
        this.setHoursRequired(hoursRequired);
        this.setDone(false);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    private void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getHoursRequired() {
        return hoursRequired;
    }

    private void setHoursRequired(int hoursRequired) {
        this.hoursRequired = hoursRequired;
    }

    @Override
    public boolean isDone() {
        return this.isDone;
    }

    private void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public void update() {
        this.setHoursRequired(this.getHoursRequired() - this.getEmployee().getHoursPerWeek());
        if (this.getHoursRequired() <= 0) {
            JobDone finishedJob = new JobDoneEvent(this, this.getName());
            System.out.println(finishedJob.getResult());
            this.setDone(true);
        }
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.getName(), this.getHoursRequired());
    }
}
