package foodShortage.models;

public class Rebel extends Person {

    private String group;

    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;
    }

    @Override
    public void buyFood() {
        this.foodBought += 5;
    }

    @Override
    public int getFoodBought() {
        return this.foodBought;
    }
}
