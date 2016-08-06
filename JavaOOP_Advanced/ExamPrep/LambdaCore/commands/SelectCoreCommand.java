package bg.softuni.models.commands;

import bg.softuni.models.constants.Messages;

public class SelectCoreCommand extends CommandAbstract {

    public SelectCoreCommand() {

    }

    @Override
    public String execute(String... args) throws ReflectiveOperationException {
        String result;
        String coreName = args[0];

        try {
            this.getPowerPlant().selectCore(coreName);
            result = String.format(Messages.SUCCESSFULLY_SELECTED_CORE_MESSAGE, coreName);
        } catch (IllegalArgumentException e) {
            result = String.format(Messages.FAILED_TO_SELECT_CORE_MESSAGE, coreName);
        }

        return result + System.lineSeparator();
    }
}
