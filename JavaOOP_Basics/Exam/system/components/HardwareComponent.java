package exam.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class HardwareComponent extends GeneralComponent {

    protected int maxCapacity;
    protected int maxMemory;
    private int usedCapacity;
    private int usedMemory;
    private List<SoftwareComponent> softwareComponents;

    protected HardwareComponent(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type);
        this.setMaxCapacity(maxCapacity);
        this.setMaxMemory(maxMemory);
        this.softwareComponents = new ArrayList<>();
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int getMaxMemory() {
        return this.maxMemory;
    }

    public int getUsedCapacity() {
        return this.usedCapacity;
    }

    public int getUsedMemory() {
        return this.usedMemory;
    }

//    public List<SoftwareComponent> getSoftwareComponents() {
//        return this.softwareComponents;
//    }

    public int getSoftwareCountInThisHardware() {
        return this.softwareComponents.size();
    }

    protected void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    protected void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }


    private boolean checkIsMemoryEnough(SoftwareComponent softwareComponent) {
        return this.maxMemory - this.usedMemory >= softwareComponent.getMemoryConsumption();
    }

    private boolean checkIsCapacityEnough(SoftwareComponent softwareComponent) {
        return this.maxCapacity - this.usedCapacity >= softwareComponent.getCapacityConsumption();
    }

    public void releaseSoftwareComponent(String softwareName) {

        Iterator<SoftwareComponent> softwareComponentIterator = this.softwareComponents.iterator();
        while (softwareComponentIterator.hasNext()) {
            SoftwareComponent softwareComponent = softwareComponentIterator.next();
            if (softwareComponent.getName().equals(softwareName)) {
                this.usedCapacity -= softwareComponent.getCapacityConsumption();
                this.usedMemory -= softwareComponent.getMemoryConsumption();
                softwareComponentIterator.remove();
            }
        }
    }

    public void addSoftwareComponent(SoftwareComponent softwareComponent) {
        if (this.checkIsCapacityEnough(softwareComponent)
                && (this.checkIsMemoryEnough(softwareComponent))) {
            this.usedCapacity += softwareComponent.getCapacityConsumption();
            this.usedMemory += softwareComponent.getMemoryConsumption();
            this.softwareComponents.add(softwareComponent);
        }
    }

    public int getLightSoftwareCount() {
        return this.softwareComponents
                .stream()
                .filter(e -> e.getType().equals("Light"))
                .collect(Collectors.toList()).size();
    }

    public int getExpressSoftwareCount() {
        return this.softwareComponents
                .stream()
                .filter(e -> e.getType().equals("Express"))
                .collect(Collectors.toList()).size();
    }

    @Override
    public String toString() {
        StringBuilder hardwareInfo = new StringBuilder();
        hardwareInfo.append(String.format("Hardware Component - %s", this.getName()));
        hardwareInfo.append(System.lineSeparator());
        hardwareInfo.append(String.format("Express Software Components - %d", this.getExpressSoftwareCount()));
        hardwareInfo.append(System.lineSeparator());
        hardwareInfo.append(String.format("Light Software Components - %d", this.getLightSoftwareCount()));
        hardwareInfo.append(System.lineSeparator());
        hardwareInfo.append(String.format("Memory Usage: %d / %d", this.getUsedMemory(), this.getMaxMemory()));
        hardwareInfo.append(System.lineSeparator());
        hardwareInfo.append(String.format("Capacity Usage: %d / %d", this.getUsedCapacity(), this.getMaxCapacity()));
        hardwareInfo.append(System.lineSeparator());
        hardwareInfo.append(String.format("Type: %s", this.getType()));
        hardwareInfo.append(System.lineSeparator());
        hardwareInfo.append("Software Components: ");
        if (this.softwareComponents.size() > 0) {
            for (SoftwareComponent softwareComponent : this.softwareComponents) {
                hardwareInfo.append(softwareComponent.getName()).append(", ");
            }
            hardwareInfo.setLength(hardwareInfo.length() - 2);
        } else {
            hardwareInfo.append("None");
        }
        return hardwareInfo.toString();
    }
}
