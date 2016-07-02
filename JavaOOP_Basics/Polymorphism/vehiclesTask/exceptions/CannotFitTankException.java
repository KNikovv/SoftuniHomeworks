package vehiclesTask.exceptions;

public class CannotFitTankException extends FuelException {

    public CannotFitTankException() {
        super("Cannot fit fuel in tank");
    }
}
