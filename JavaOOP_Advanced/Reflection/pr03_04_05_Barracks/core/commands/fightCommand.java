package pr0304Barracks.core.commands;

public class fightCommand extends Command {

    protected fightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
