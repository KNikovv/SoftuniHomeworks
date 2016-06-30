package mordorCrueltyPlan.main;

import mordorCrueltyPlan.factories.FoodFactory;
import mordorCrueltyPlan.factories.MoodFactory;
import mordorCrueltyPlan.foods.*;
import mordorCrueltyPlan.moods.Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String[] food = buffReader.readLine().split("\\s+");
        FoodFactory foodFactory = new FoodFactory();
        for (String current : food) {
            Food currentFood;
            switch (current.toLowerCase()) {
                case "cram":
                    currentFood = new Cram();
                    break;
                case "lembas":
                    currentFood = new Lembas();
                    break;
                case "apple":
                case "melon":
                    currentFood = new AppleOrMelon();
                    break;
                case "honeycake":
                    currentFood = new HoneyCake();
                    break;
                case "mushrooms":
                    currentFood = new Mushrooms();
                    break;
                default:
                    currentFood = new OtherFood();
            }
            foodFactory.addFood(currentFood);
        }
        MoodFactory moodFactory = new MoodFactory(foodFactory);
        moodFactory.calculateHappinessPoints();
        System.out.println(moodFactory.getTotalPoints());

        Mood resultMood = moodFactory.getMood();
        System.out.println(resultMood);
    }
}
