package mordorCrueltyPlan.factories;

import mordorCrueltyPlan.foods.Food;
import mordorCrueltyPlan.moods.*;

public class MoodFactory {

    FoodFactory foodFactory;
    int totalPoints;

    public MoodFactory(FoodFactory foodFactory) {
        this.foodFactory = foodFactory;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void calculateHappinessPoints() {
        int total = 0;
        for (Food food : this.foodFactory.getFoods()) {
            total += food.getHappinessPoints();
        }
        this.totalPoints = total;
    }

    public Mood getMood() {
        if (this.totalPoints < -5) {
            return new Angry();
        } else if (totalPoints >= -5 && totalPoints < 0) {
            return new Sad();
        } else if (totalPoints >= 0 && totalPoints <= 15) {
            return new Happy();
        }else {
            return new JavaScript();
        }
    }
}
