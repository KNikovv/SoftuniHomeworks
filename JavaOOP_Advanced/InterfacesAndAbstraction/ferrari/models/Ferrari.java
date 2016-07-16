package ferrari.models;

import ferrari.interfaces.Car;

public class Ferrari implements Car {

    public static final String FERRARI_MODEL;

    static {
        FERRARI_MODEL = "488-Spider";
    }

    private String driverName;
    private StringBuilder messagesBuilder;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.messagesBuilder = new StringBuilder();
    }

    @Override
    public void useBrakes() {
        this.messagesBuilder.append("/Brakes!/");
    }

    @Override
    public void pushGasPedal() {
        this.messagesBuilder.append("Zadu6avam sA!/");
    }

    @Override
    public String toString() {

        this.messagesBuilder.append(FERRARI_MODEL);
        this.useBrakes();
        this.pushGasPedal();
        this.messagesBuilder.append(this.driverName);

        return this.messagesBuilder.toString();
    }
}
