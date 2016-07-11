package exam.commands;

import exam.SystemCore;

public class SystemSplitCommand extends Command {

    public SystemSplitCommand(SystemCore core) {
        super(core);
    }

    @Override
    public void execute(String[] args) {
        this.getCore().printAllInformation();
    }
}
