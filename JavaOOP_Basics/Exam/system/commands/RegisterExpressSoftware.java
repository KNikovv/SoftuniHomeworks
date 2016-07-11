package exam.commands;

import exam.SystemCore;
import exam.components.ExpressSoftwareComponent;
import exam.components.HardwareComponent;
import exam.components.SoftwareComponent;

public class RegisterExpressSoftware extends Command {

    public RegisterExpressSoftware(SystemCore core) {
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
                SoftwareComponent softwareComponent = new ExpressSoftwareComponent(softwareName, "Express",
                        hardwareName, maxCapacityConsumption, maxMemoryConsumption);
                hardwareComponent.addSoftwareComponent(softwareComponent);
                return;
            }
        }
    }
}
