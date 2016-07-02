package vehiclesTask.vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double litersPerKm,double tankCapacity) {
        super(fuelQuantity, litersPerKm,tankCapacity);
    }

    @Override
    public void drive(double distance, double extraLiters) {
        super.drive(distance, extraLiters);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel*0.95d);
    }
}
