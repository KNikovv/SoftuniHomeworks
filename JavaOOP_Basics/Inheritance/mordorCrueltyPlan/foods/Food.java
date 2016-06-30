package mordorCrueltyPlan.foods;

public abstract class Food {

    private int happinessPoints;

    public Food(int happinessPoints) {
       this.setHappinessPoints(happinessPoints);
    }

    public int getHappinessPoints() {
        return happinessPoints;
    }

    private void setHappinessPoints(int happinessPoints) {
        this.happinessPoints = happinessPoints;
    }
}
