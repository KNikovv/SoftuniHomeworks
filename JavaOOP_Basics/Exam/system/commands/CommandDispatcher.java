package exam.commands;

import exam.SystemCore;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {

    private SystemCore systemCore;
    private Map<String, Command> commands;

    public CommandDispatcher() {
        this.commands = new HashMap<>();
    }

    public void setSystemCore(SystemCore systemCore) {
        this.systemCore = systemCore;
    }

    public void seedCommands() {
        this.commands.put("RegisterPowerHardware", new RegisterPowerHardware(this.systemCore));
        this.commands.put("RegisterHeavyHardware", new RegisterHeavyHardware(this.systemCore));
        this.commands.put("RegisterExpressSoftware", new RegisterExpressSoftware(this.systemCore));
        this.commands.put("RegisterLightSoftware", new RegisterLightSoftware(this.systemCore));
        this.commands.put("ReleaseSoftwareComponent", new ReleaseSoftwareComponent(this.systemCore));
        this.commands.put("Analyze", new AnalyzeCommand(this.systemCore));
        this.commands.put("System Split", new SystemSplitCommand(this.systemCore));
        this.commands.put("Dump",new Dump(this.systemCore));
        this.commands.put("Restore",new Restore(this.systemCore));
        this.commands.put("Destroy",new Destroy(this.systemCore));
        this.commands.put("DumpAnalyze",new DumpAnalyze(this.systemCore));
    }

    public void dispatchCommand(String command, String[] args) {
        this.commands.get(command).execute(args);
    }
}
