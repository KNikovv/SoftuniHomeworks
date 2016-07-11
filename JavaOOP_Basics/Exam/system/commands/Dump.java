package exam.commands;

import exam.SystemCore;

public class Dump extends Command {

    public Dump(SystemCore core) {
        super(core);
    }

    @Override
    public void execute(String[] args) {
        String hardwareComponentName = args[0].substring(0,args[0].length()-1);

        this.getCore().dump(hardwareComponentName);
    }
}
