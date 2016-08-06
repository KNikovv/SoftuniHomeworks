package bg.softuni.models.commands;

import bg.softuni.models.constants.Messages;

public class RemoveCoreCommand extends CommandAbstract {

    public RemoveCoreCommand() {

    }

    @Override
    public String execute(String... args) throws ReflectiveOperationException {
        String result;
        String coreName = args[0];
        try {
            this.getPowerPlant().removeCore(coreName);
            result = String.format(Messages.SUCCESSFULLY_REMOVED_CORE_MESSAGE, coreName);
        } catch (IllegalArgumentException e) {
            result = String.format(Messages.FAILED_TO_REMOVE_CORE_MESSAGE, coreName);
        }

        return result + System.lineSeparator();
    }
}
