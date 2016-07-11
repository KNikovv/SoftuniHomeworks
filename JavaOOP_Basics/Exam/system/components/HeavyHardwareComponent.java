package exam.components;

public class HeavyHardwareComponent extends HardwareComponent {

    private static final int PERCENTAGE_INCREASE_CAPACITY_MODIFIER;
    private static final int MULTIPLIER_VALUE;
    private static final int DIVIDER_VALUE;

    static {
        MULTIPLIER_VALUE = 1;
        DIVIDER_VALUE = 4;
        PERCENTAGE_INCREASE_CAPACITY_MODIFIER = 2;
    }

    public HeavyHardwareComponent(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type, maxCapacity, maxMemory);
    }

    @Override
    protected void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity * PERCENTAGE_INCREASE_CAPACITY_MODIFIER;
    }

    @Override
    protected void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory - ((maxMemory * MULTIPLIER_VALUE) / DIVIDER_VALUE);
    }
}
