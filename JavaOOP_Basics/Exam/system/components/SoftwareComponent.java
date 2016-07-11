package exam.components;

public abstract class SoftwareComponent extends GeneralComponent {

    protected int capacityConsumption;
    protected int memoryConsumption;
    private String hardwareName;

    protected SoftwareComponent(String name, String type,String hardwareName, int capacityConsumption, int memoryConsumption) {
        super(name, type);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
        this.setHardwareName(hardwareName);
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    private void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
}
