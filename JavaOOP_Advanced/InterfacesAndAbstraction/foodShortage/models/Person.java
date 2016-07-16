package foodShortage.models;

import foodShortage.interfaces.Buyer;

public abstract class Person implements Buyer {

    private String name;
    private int age;
    protected int foodBought;

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.foodBought = 0;
    }

    public String getName() {
        return name;
    }
}
