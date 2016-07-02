package wildFarm.animals;

import wildFarm.foods.Food;

public abstract class Animal {

    private String animalName;
    private double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
       this.setFoodEaten(0);
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public String getAnimalName() {
        return animalName;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }

    public void consumeFood(int quantity){
        this.setFoodEaten(this.getFoodEaten() + quantity);
    }
    public abstract void makeSound();
    public abstract void eatFood(Food food);


}
