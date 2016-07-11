package exam;

import exam.commands.CommandDispatcher;
import exam.components.HardwareComponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SystemCore {

    private List<HardwareComponent> hardwareComponents;
    private List<HardwareComponent> dumpedHardwareComponents;
    private CommandDispatcher commandDispatcher;
    private BufferedReader bufferedReader;

    public SystemCore(CommandDispatcher commandDispatcher) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.hardwareComponents = new ArrayList<>();
        this.dumpedHardwareComponents = new ArrayList<>();
        this.commandDispatcher = commandDispatcher;
        this.commandDispatcher.setSystemCore(this);
    }

    public List<HardwareComponent> getHardwareComponents() {
        return hardwareComponents;
    }

    private int getCurrentMemoryTaken() {
        return this.getHardwareComponents().stream().mapToInt(HardwareComponent::getUsedMemory).sum();
    }

    private int getCurrentCapacityTaken() {
        return this.getHardwareComponents().stream().mapToInt(HardwareComponent::getUsedCapacity).sum();
    }

    private int getCurrentMaxMemoryUsage() {
        return this.getHardwareComponents().stream().mapToInt(HardwareComponent::getMaxMemory).sum();
    }

    private int getCurrentMaxCapacityUsage() {
        return this.getHardwareComponents().stream().mapToInt(HardwareComponent::getMaxCapacity).sum();
    }

    public void processInput() throws IOException {
        boolean isInRegistryMode = true;
        this.commandDispatcher.seedCommands();

        while (isInRegistryMode) {
            String line = this.bufferedReader.readLine();
            String[] args = line.split("\\(");
            if (args[0] == null || args[0].equals("")) {
                return;
            }
            if (args[0].trim().equals("System Split")) {
                this.commandDispatcher.dispatchCommand(args[0], args);
                isInRegistryMode = false;
                continue;
            }
            String command = args[0];
            String[] componentParams = args[1].split(", ");

            this.commandDispatcher.dispatchCommand(command, componentParams);
        }
    }

    public void addHardwareComponent(HardwareComponent hardwareComponent) {
        this.hardwareComponents.add(hardwareComponent);
    }

    private int getHardwareCount() {
        return this.getHardwareComponents().size();
    }

    private int getSoftwareCount() {
        return this.getHardwareComponents().stream().mapToInt
                (HardwareComponent::getSoftwareCountInThisHardware).sum();
    }

    private int getDumpedPowerHardCount() {
        return this.dumpedHardwareComponents.stream().filter(e -> e.getType().equals("Power")).collect(Collectors
                .toList()).size();
    }

    private int getDumpedHeavyHardCount() {
        return this.dumpedHardwareComponents.stream().filter(e -> e.getType().equals("Heavy")).collect(Collectors
                .toList()).size();
    }

    private int getDumpExpressSoftCount() {
        return this.dumpedHardwareComponents.stream().mapToInt(HardwareComponent::getExpressSoftwareCount).sum();
    }

    private int getDumpLightSoftCount() {
        return this.dumpedHardwareComponents.stream().mapToInt(HardwareComponent::getLightSoftwareCount).sum();
    }

    private int getDumpMemory() {
        return this.dumpedHardwareComponents.stream().mapToInt(HardwareComponent::getUsedMemory).sum();
    }

    private int getDumpCapacity() {
        return this.dumpedHardwareComponents.stream().mapToInt(HardwareComponent::getUsedCapacity).sum();
    }

    public void showCurrentStatistics() {
        StringBuilder statisticsBuilder = new StringBuilder();
        statisticsBuilder.append("System Analysis").append(System.lineSeparator());
        statisticsBuilder.append(String.format("Hardware Components: %d", this.getHardwareCount()));
        statisticsBuilder.append(System.lineSeparator());
        statisticsBuilder.append(String.format("Software Components: %d", this.getSoftwareCount()));
        statisticsBuilder.append(System.lineSeparator());
        statisticsBuilder.append(
                String.format("Total Operational Memory: %d / %d", this.getCurrentMemoryTaken(), this
                        .getCurrentMaxMemoryUsage()));
        statisticsBuilder.append(System.lineSeparator());
        statisticsBuilder.append(
                String.format("Total Capacity Taken: %d / %d", this.getCurrentCapacityTaken(), this
                        .getCurrentMaxCapacityUsage()));
        statisticsBuilder.append(System.lineSeparator());
        System.out.print(statisticsBuilder);
    }

    public void printAllInformation() {
        this.hardwareComponents.stream()
                .sorted((hard1, hard2) -> hard2.getType()
                        .compareTo(hard1.getType())).forEach(System.out::println);
    }

    public void dump(String hardwareComponentName) {
        Iterator<HardwareComponent> hardwareComponentIterator = this.hardwareComponents.iterator();
        while (hardwareComponentIterator.hasNext()) {
            HardwareComponent currentHardwareComponent = hardwareComponentIterator.next();
            if (currentHardwareComponent.getName().equals(hardwareComponentName)) {
                this.dumpedHardwareComponents.add(currentHardwareComponent);
                hardwareComponentIterator.remove();
            }
        }
    }

    public void restore(String hardwareComponentName) {
        Iterator<HardwareComponent> dumpedComponentIterator = this.dumpedHardwareComponents.iterator();
        while (dumpedComponentIterator.hasNext()) {
            HardwareComponent currentHardwareComponent = dumpedComponentIterator.next();
            if (currentHardwareComponent.getName().equals(hardwareComponentName)) {
                this.hardwareComponents.add(currentHardwareComponent);
                dumpedComponentIterator.remove();
            }
        }

    }

    public void destroyFromDump(String hardwareComponentName) {
        this.dumpedHardwareComponents.removeIf(e -> e.getName().equals(hardwareComponentName));
    }

    public void displayDumpAnalysis() {
        StringBuilder dumpBuilder = new StringBuilder();
        dumpBuilder.append("Dump Analysis").append(System.lineSeparator());
        dumpBuilder.append(String.format("Power Hardware Components: %d",this.getDumpedPowerHardCount()));
        dumpBuilder.append(System.lineSeparator());
        dumpBuilder.append(String.format("Heavy Hardware Components: %d",this.getDumpedHeavyHardCount()));
        dumpBuilder.append(System.lineSeparator());
        dumpBuilder.append(String.format("Express Software Components: %d",this.getDumpExpressSoftCount()));
        dumpBuilder.append(System.lineSeparator());
        dumpBuilder.append(String.format("Light Software Components: %d",this.getDumpLightSoftCount()));
        dumpBuilder.append(System.lineSeparator());
        dumpBuilder.append(String.format("Total Dumped Memory: %d",this.getDumpMemory()));
        dumpBuilder.append(System.lineSeparator());
        dumpBuilder.append(String.format("Total Dumped Capacity: %d",this.getDumpCapacity()));
        dumpBuilder.append(System.lineSeparator());
        System.out.println(dumpBuilder);
    }
}
