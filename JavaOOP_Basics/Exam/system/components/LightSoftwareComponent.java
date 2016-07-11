package exam.components;

public class LightSoftwareComponent extends SoftwareComponent {

    public static final int DIVIDER_VALUE;

    static {
        DIVIDER_VALUE = 2;
    }

    public LightSoftwareComponent(String name, String type, String hardwareName, int capacityConsumption, int
            memoryConsumption) {
        super(name, type, hardwareName, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption + (capacityConsumption / DIVIDER_VALUE);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption - (memoryConsumption / DIVIDER_VALUE);
    }
}
