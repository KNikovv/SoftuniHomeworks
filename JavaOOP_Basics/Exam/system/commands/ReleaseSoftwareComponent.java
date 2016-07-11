package exam.commands;

import exam.SystemCore;

public class ReleaseSoftwareComponent extends Command {

    public ReleaseSoftwareComponent(SystemCore core) {
        super(core);
    }



    @Override
    public void execute(String[] args) {
        String hardwareName = args[0];
        String softwareName = args[1].substring(0, args[1].trim().length()-1);

        this.getCore().getHardwareComponents().stream().filter(hardwareComponent -> hardwareComponent.getName()
                .equals(hardwareName)).forEach(hardwareComponent -> {
            hardwareComponent.releaseSoftwareComponent(softwareName);
        });
    }
}
