package rawData;

import java.util.List;

public class Car {
    private String carModel;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String carModel, Engine engine, Cargo cargo, List<Tire> tires) {
        this.carModel = carModel;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return this.carModel;
    }
}
