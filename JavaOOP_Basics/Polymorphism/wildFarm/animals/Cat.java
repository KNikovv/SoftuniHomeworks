package wildFarm.animals;

import wildFarm.foods.Food;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, double animalWeight, String livingRegion,String breed) {
        super(animalName, animalWeight, livingRegion);
        this.breed = breed;
    }


    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eatFood(Food food) {
        this.consumeFood(food.getQuantity());
    }

    @Override
    public String toString() {

        return String.format("%s[%s, %s, %s, %s, %s]",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                this.getBreed(),
                format.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());

    }
}
