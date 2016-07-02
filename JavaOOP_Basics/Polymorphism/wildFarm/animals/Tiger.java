package wildFarm.animals;

import wildFarm.exceptions.NotEatingException;
import wildFarm.foods.Food;

public class Tiger extends Felime {


    public Tiger(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            throw new NotEatingException("Tigers are not eating that type of food!");
        }
        this.consumeFood(food.getQuantity());
    }
}
