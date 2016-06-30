package mordorCrueltyPlan.factories;

import mordorCrueltyPlan.foods.Food;

import java.util.ArrayList;

public class FoodFactory {

    private ArrayList<Food> foods;

    public FoodFactory() {
        this.foods = new ArrayList<>();
    }

    public void addFood(Food food){
        this.foods.add(food);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }
}
