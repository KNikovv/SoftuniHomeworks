package pizzaCalories.models;

import java.util.HashMap;

public class Topping {

    private static final int BASE_CALORIE_PER_GRAM = 2;
    private String toppingType;
    private HashMap<String, Double> toppingMap;
    private double toppingWeight;

    public Topping(String toppingType, double toppingWeight) {
        this.constructMap();
        this.setToppingType(toppingType);
        this.setToppingWeight(toppingWeight);
    }
    public double getToppingCalories(){
        double toppingModifier = this.toppingMap.get(this.toppingType.toLowerCase());

        return BASE_CALORIE_PER_GRAM*this.toppingWeight*toppingModifier;
    }
    private String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        if (!this.toppingMap.containsKey(toppingType.toLowerCase())) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private double getToppingWeight() {
        return toppingWeight;
    }

    private void setToppingWeight(double toppingWeight) {
        if (toppingWeight < 1 || toppingWeight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].\n",
                    this.getToppingType()));
        }
        this.toppingWeight = toppingWeight;
    }

    private void constructMap() {
        this.toppingMap = new HashMap<String, Double>() {{
            put("meat", 1.2);
            put("veggies", 0.8);
            put("cheese", 1.1);
            put("sauce", 0.9);
        }};
    }
}
