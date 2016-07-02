package vehiclesTask.vehicles;

import vehiclesTask.exceptions.BelowZeroFuelException;
import vehiclesTask.exceptions.OutOfFuelException;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.jar.Pack200;


public abstract class Vehicle {

    public static HashMap<String, Double> extraLiters;
    private double tankCapacity;
    private double fuelQuantity;
    private double litersPerKm;

    static {
        extraLiters = new HashMap<>();
        extraLiters.put("Car", 0.9d);
        extraLiters.put("Truck", 1.6d);
        extraLiters.put("Bus", 1.4d);
    }

    public Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setLitersPerKm(litersPerKm);
        this.setTankCapacity(tankCapacity);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new BelowZeroFuelException();
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitersPerKm() {
        return this.litersPerKm;
    }

    private void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    private double getDistanceWithEnoughFuel() {
        double distanceWithEnoughFuel = this.getFuelQuantity() / this.getLitersPerKm();
        return distanceWithEnoughFuel;
    }

    public void drive(double distance, double extraLiters) {
        if (distance <= this.getDistanceWithEnoughFuel()) {
            double fuelConsumed = distance * (this.getLitersPerKm() + extraLiters);
            this.setFuelQuantity(this.getFuelQuantity() - fuelConsumed);
            String vehicle = this.getClass().getSimpleName();
            printTraveled(vehicle, distance);
        } else {
            throw new OutOfFuelException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
    }

    private void printTraveled(String vehicle, double distance) {
        String kilometers = new DecimalFormat("0.####").format(distance);
        System.out.printf("%s travelled %s km\n", vehicle, kilometers);
    }

    public void refuel(double fuel)  {
            this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
