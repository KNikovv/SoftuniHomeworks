package wasteDisposal.commands;

public class StatusCommand extends CommandAbstract {

    public StatusCommand() {
        super();
    }
    @Override
    public String execute(String... args) {
        String result = this.getRecyclingStation().getStatus();

        return result;
    }
}
