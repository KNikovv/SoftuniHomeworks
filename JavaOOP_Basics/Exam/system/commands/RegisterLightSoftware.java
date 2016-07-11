package exam.commands;

import exam.SystemCore;
import exam.components.HardwareComponent;
import exam.components.LightSoftwareComponent;
import exam.components.SoftwareComponent;

public class RegisterLightSoftware extends Command {

    public RegisterLightSoftware(SystemCore core) {
        super(core);
    }



    @Override
    public void execute(String[] args) {
        String hardwareName = args[0];
        String softwareName = args[1];
        int maxCapacityConsumption = Integer.valueOf(args[2]);
        int maxMemoryConsumption = Integer.valueOf(args[3].substring(0,args[3].trim().length()-1));

        for (HardwareComponent hardwareComponent : this.getCore().getHardwareComponents()) {
            if (hardwareComponent.getName().equals(hardwareName)) {
                SoftwareComponent softwareComponent = new LightSoftwareComponent(softwareName, "Light", hardwareName,
                        maxCapacityConsumption, maxMemoryConsumption);
                hardwareComponent.addSoftwareComponent(softwareComponent);
                return;
            }
        }
    }
}
