package exam.components;

public class ExpressSoftwareComponent extends SoftwareComponent {

    private static final int INCREASE_MEMORY_CONSUMPTION_MODIFIER;

    static {
        INCREASE_MEMORY_CONSUMPTION_MODIFIER = 2;
    }

    public ExpressSoftwareComponent(String name,String type,String hardwareName,  int capacityConsumption, int memoryConsumption) {
        super(name,type,hardwareName, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption * INCREASE_MEMORY_CONSUMPTION_MODIFIER;
    }

}
