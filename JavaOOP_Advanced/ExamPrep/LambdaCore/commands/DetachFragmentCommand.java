package bg.softuni.models.commands;

import bg.softuni.models.constants.Messages;

public class DetachFragmentCommand extends CommandAbstract {

    public DetachFragmentCommand() {

    }

    @Override
    public String execute(String... args) throws ReflectiveOperationException {
        String result;
        try {
            result = this.getPowerPlant().detachFragmentFromSelectedCore();
        } catch (IllegalArgumentException e) {
            result = Messages.FAILED_TO_DETACH_FRAGMENT_MESSAGE;
        }

        return result + System.lineSeparator();
    }
}
