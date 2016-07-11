package exam.commands;

import exam.SystemCore;
import exam.components.HardwareComponent;
import exam.components.PowerHardwareComponent;

public class RegisterPowerHardware extends Command {

    public RegisterPowerHardware(SystemCore core) {
        super(core);
    }



    @Override
    public void execute(String[] args) {
        String name = args[0];
        int maxCapacity = Integer.valueOf(args[1]);
        int maxMemory = Integer.valueOf(args[2].substring(0,args[2].trim().length()-1));

        HardwareComponent hardwareComponent = new PowerHardwareComponent(name, "Power", maxCapacity, maxMemory);
        this.getCore().addHardwareComponent(hardwareComponent);
    }
}
