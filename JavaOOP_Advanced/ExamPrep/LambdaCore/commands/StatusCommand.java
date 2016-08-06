package bg.softuni.models.commands;

public class StatusCommand extends CommandAbstract {

    public StatusCommand() {

    }

    @Override
    public String execute(String... args) throws ReflectiveOperationException {
        String result = this.getPowerPlant().getStatusReport();
        return result;
    }
}
