package exam.commands;

import exam.SystemCore;

public class Restore extends Command {

    public Restore(SystemCore core) {
        super(core);
    }

    @Override
    public void execute(String[] args) {
        String hardwareComponentName = args[0].substring(0,args[0].length()-1);

        this.getCore().restore(hardwareComponentName);
    }
}
