package exam.commands;

import exam.SystemCore;

public class AnalyzeCommand extends Command {

    public AnalyzeCommand(SystemCore core) {
        super(core);
    }


    @Override
    public void execute(String[] args) {
        this.getCore().showCurrentStatistics();
    }
}
