package vehiclesTask.exceptions;

public class BelowZeroFuelException extends FuelException{

    public BelowZeroFuelException() {
        super("Fuel must be positive number");
    }
}
