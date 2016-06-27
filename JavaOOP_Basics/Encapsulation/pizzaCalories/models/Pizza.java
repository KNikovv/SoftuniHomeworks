package pizzaCalories.models;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String pizzaName;
    private List<Topping> toppings;
    private Dough dough;
    private double totalCalories;
    private int numberOfToppings;

    public Pizza(String pizzaName,int numberOfToppings) {
        this.setPizzaName(pizzaName);
        this.setNumberOfToppings(numberOfToppings);
        this.setToppings(new ArrayList<>());
    }
    public  void calculateCalories(){
        for(Topping topping : this.toppings){
            this.setTotalCalories(this.getTotalCalories() + topping.getToppingCalories());
        }
        this.setTotalCalories(this.getTotalCalories() + this.dough.calcDoughCalories());
    }
    private String getPizzaName() {
        return pizzaName;
    }

    private void setPizzaName(String pizzaName) {
        if(pizzaName.length()<1 || pizzaName.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.pizzaName = pizzaName;
    }

    private int getNumberOfToppings() {
        return numberOfToppings;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if(numberOfToppings<0 || numberOfToppings>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }
    public void addDough(Dough dough){
        this.dough = dough;
    }
    private List<Topping> getToppings() {
        return toppings;
    }

    private void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    private Dough getDough() {
        return dough;
    }

    private void setDough(Dough dough) {
        this.dough = dough;
    }

    private double getTotalCalories() {
        return totalCalories;
    }

    private void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f Calories.",this.getPizzaName(),this.getTotalCalories());
    }
}
