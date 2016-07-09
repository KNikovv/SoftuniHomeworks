package sample.home;

import sample.models.Adult;
import sample.models.Child;

import java.util.ArrayList;
import java.util.List;

public abstract class Home {

    private double salaries;
    private double budget;
    private double consumption;
    protected List<Adult> adults;
    protected List<Child> children;
    protected int roomsConsumption;
    protected double tvConsumption;
    protected double fridgeConsumption;
    protected double stoveConsumption;
    protected double laptopConsumption;

    protected Home() {
        this.salaries = 0;
        this.budget = 0;
        this.consumption = 0;
        this.roomsConsumption = 0;
        this.tvConsumption = 0;
        this.fridgeConsumption = 0;
        this.stoveConsumption = 0;
        this.laptopConsumption = 0;
        this.adults = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void calculateSalaries() {
        this.salaries = adults.stream().mapToDouble(Adult::getIncome).sum();
    }

    public int getPopulationCount() {
        return this.adults.size() + this.children.size();
    }

    public double getConsumption() {
        return this.consumption;
    }

    public void calculateConsumption() {
        this.consumption = this.roomsConsumption +
                this.tvConsumption + this.fridgeConsumption +
                this.stoveConsumption + this.laptopConsumption
                + this.children.stream().mapToDouble(Child::getTotalCost).sum();
    }

    public boolean payConsumption() {
        if (this.budget >= this.consumption) {
            this.budget -= this.consumption;
            return true;
        }
        return false;
    }

    public void paySalaries() {
        this.budget += this.salaries;
    }
}
