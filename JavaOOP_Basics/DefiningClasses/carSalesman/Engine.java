package carSalesman;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Engine {
    String engineModel;
    Integer enginePower;
    String engineDisplacement;
    String efficiency;

    Engine(String model, Integer power, String displacement, String efficiency) {
        this.setEngineModel(model);
        this.setEnginePower(power);
        this.setEngineDisplacement(displacement);
        this.setEfficiency(efficiency);
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    private void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public int getEnginePower() {
        return this.enginePower;
    }

    private void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public String getEngineDisplacement() {
        return this.engineDisplacement;
    }

    private void setEngineDisplacement(String engineDisplacement) {
        if (engineDisplacement == null) {
            this.engineDisplacement = "n/a";
            return;
        }
        this.engineDisplacement = engineDisplacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    private void setEfficiency(String efficiency) {
        if (efficiency == null) {
            this.efficiency = "n/a";
            return;
        }
        this.efficiency = efficiency;
    }
}
