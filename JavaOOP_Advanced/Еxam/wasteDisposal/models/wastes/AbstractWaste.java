package wasteDisposal.models.wastes;

import wasteDisposal.contracts.Waste;

public class AbstractWaste implements Waste {

    private String name;
    private double volumePerKg;
    private double weight;

    protected AbstractWaste(String name, double weight, double volumePerKg) {
        this.setName(name);
        this.setWeight(weight);
        this.setVolumePerKg(volumePerKg);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    private void setName(String name) {
        this.name = name;
    }

    protected void setVolumePerKg(double volumePerKg) {
        this.volumePerKg = volumePerKg;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }
}
