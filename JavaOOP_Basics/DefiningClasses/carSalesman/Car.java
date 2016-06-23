package carSalesman;

public class Car {
    private String carModel;
    private Engine carEngine;
    private String carWeight;
    private String carColor;

    public Car(String carModel, Engine carEngine, String carWeight, String carColor) {
        this.setCarModel(carModel);
        this.setCarEngine(carEngine);
        this.setCarWeight(carWeight);
        this.setCarColor(carColor);
    }

    public String getCarModel() {
        return carModel;
    }

    private void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Engine getCarEngine() {
        return carEngine;
    }

    private void setCarEngine(Engine carEngine) {
        this.carEngine = carEngine;
    }

    public String getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(String carWeight) {
        if (carWeight == null) {
            this.carWeight = "n/a";
            return;
        }
        this.carWeight = carWeight;
    }

    public String getCarColor() {
        return carColor;
    }

    private void setCarColor(String carColor) {
        if (carColor == null) {
            this.carColor = "n/a";
            return;
        }
        this.carColor = carColor;
    }

    @Override
    public String toString() {
        StringBuilder carBuilder = new StringBuilder();
        carBuilder.append(String.format("%s:\n",this.getCarModel()));
        carBuilder.append(String.format("  %s:\n",this.getCarEngine().getEngineModel()));
        carBuilder.append(String.format("\tPower: %d\n",this.getCarEngine().getEnginePower()));
        carBuilder.append(String.format("\tDisplacement: %s\n",this.getCarEngine().getEngineDisplacement()));
        carBuilder.append(String.format("\tEfficiency: %s\n",this.getCarEngine().getEfficiency()));
        carBuilder.append(String.format("  Weight: %s\n",this.getCarWeight()));
        carBuilder.append(String.format("  Color: %s",this.getCarColor()));

        String output = carBuilder.toString();
        return output;
    }
}
