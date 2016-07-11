package exam.commands;

import exam.SystemCore;

public abstract class Command {

    private SystemCore core;

    public Command(SystemCore core) {
        this.core = core;
    }

    public SystemCore getCore() {
        return this.core;
    }

    public abstract void execute(String[] args);
}
