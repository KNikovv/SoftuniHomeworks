package vehiclesTask.vehicles;

import vehiclesTask.exceptions.CannotFitTankException;

public class Bus extends Vehicle {


    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }


    @Override
    public void drive(double distance,double extraLiters) {
        super.drive(distance,extraLiters);
    }

    @Override
    public void refuel(double fuel) {
        if (this.getFuelQuantity() + fuel > this.getTankCapacity()) {
            throw new CannotFitTankException();
        }
        super.refuel(fuel);
    }
}
