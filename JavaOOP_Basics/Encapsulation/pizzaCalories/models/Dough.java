package pizzaCalories.models;

import java.util.HashMap;

public class Dough {

    private static final int BASE_CALORIE_PER_GRAM = 2;
    private String flourType;
    private String bakingTechnique;
    private HashMap<String, Double> flourTypeMap;
    private HashMap<String, Double> bakingTechniqueMap;
    private double doughWeight;

    public Dough(String flourType, String bakingTechnique, double doughWeight) {
        this.constructMaps();
        this.setFlourType(flourType);
        this.setBackingTechnique(bakingTechnique);
        this.setDoughtWeight(doughWeight);
    }

    public double calcDoughCalories() {
        double flourModifier = this.flourTypeMap.get(this.flourType.toLowerCase());
        double bakingModifier = this.bakingTechniqueMap.get(this.bakingTechnique.toLowerCase());

        return (BASE_CALORIE_PER_GRAM * this.doughWeight) * flourModifier * bakingModifier;
    }

    private double getDoughtWeight() {
        return doughWeight;
    }

    private void setDoughtWeight(double doughtWeight) {
        if (doughtWeight < 1 || doughtWeight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.doughWeight = doughtWeight;
    }

    private String getFlourType() {
        return flourType;
    }

    private void setFlourType(String currentFlourType) {
        if (!this.flourTypeMap.containsKey(currentFlourType.toLowerCase())) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = currentFlourType;
    }

    private String getBackingTechnique() {
        return bakingTechnique;
    }

    private void setBackingTechnique(String currentTechnique) {

        if (!this.bakingTechniqueMap.containsKey(currentTechnique.toLowerCase())) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = currentTechnique;
    }

    private void constructMaps() {
        this.flourTypeMap = new HashMap<String, Double>() {{
            put("white", 1.5);
            put("wholegrain", 1.0);
        }};
        this.bakingTechniqueMap = new HashMap<String, Double>() {{
            put("chewy", 1.1);
            put("crispy", 0.9);
            put("homemade", 1.0);
        }};
    }
}
