package wildFarm.animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    public static final DecimalFormat format ;
    private String livingRegion;

    static {
        format = new DecimalFormat("0.#############");
    }
    public Mammal(String animalName, double animalWeight,String livingRegion) {
        super(animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {

        return String.format("%s[%s, %s, %s, %s]",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                format.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());

    }
}

