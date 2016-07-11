package exam.commands;

import exam.SystemCore;

public class DumpAnalyze extends Command {

    public DumpAnalyze(SystemCore core) {
        super(core);
    }

    @Override
    public void execute(String[] args) {
        this.getCore().displayDumpAnalysis();
    }
}
