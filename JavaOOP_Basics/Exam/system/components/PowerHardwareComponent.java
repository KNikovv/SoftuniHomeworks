package exam.components;

public class PowerHardwareComponent extends HardwareComponent {

    private static final int MULTIPLIER_VALUE;
    private static final int DIVIDER_VALUE;

    static {
        MULTIPLIER_VALUE = 3;
        DIVIDER_VALUE = 4;
    }

    public PowerHardwareComponent(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type, maxCapacity, maxMemory);
    }

    @Override
    protected void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity - ((maxCapacity * MULTIPLIER_VALUE)/ DIVIDER_VALUE);
    }

    @Override
    protected void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory + ((maxMemory * MULTIPLIER_VALUE)/ DIVIDER_VALUE);
    }
}
