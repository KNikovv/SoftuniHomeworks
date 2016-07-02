package wildFarm.animals;

import wildFarm.exceptions.NotEatingException;
import wildFarm.foods.Food;

public class Mouse extends Mammal {


    public Mouse(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            throw new NotEatingException("Mouses are not eating that type of food!");
        }
        System.out.println("A cheese was just eaten!");
        this.consumeFood(food.getQuantity());
    }
}
