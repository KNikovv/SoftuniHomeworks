package sample.models;

import java.util.ArrayList;

public class Child {

    private double foodCost;
    private ArrayList<Double> toys;
    private double totalCost;
    public Child(double foodCost, ArrayList<Double> toys) {
        this.foodCost = foodCost;
        this.toys = toys;
        this.calcTotalCost();
    }

    public double getFoodCost() {
        return foodCost;
    }

    public double getTotalCost() {
        return totalCost;
    }
    private void calcTotalCost(){
        this.totalCost = this.foodCost;
        for(Double toy : toys){
            this.totalCost+= toy;
        }
    }
    public ArrayList<Double> getToys() {
        return toys;
    }
}
