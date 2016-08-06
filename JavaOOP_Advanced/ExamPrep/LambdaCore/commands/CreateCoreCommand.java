package bg.softuni.models.commands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.constants.Messages;
import bg.softuni.models.factories.interfaces.CoreFactory;
import bg.softuni.models.models.interfaces.Core;

public class CreateCoreCommand extends CommandAbstract {

    @Inject
    private CoreFactory factory;

    public CreateCoreCommand() {

    }

    @Override
    public String execute(String... args) throws ReflectiveOperationException {
        String result;

        String type = args[0];
        int durability = Integer.valueOf(args[1]);

        Core core = this.factory.createCore(type, durability);
        if (core != null) {
            this.getPowerPlant().addCore(core);
            result = String.format(Messages.SUCCESSFULLY_CREATED_CORE_MESSAGE, core.getName());
            return result+ System.lineSeparator();
        }

        result = Messages.FAILED_TO_CREATE_CORE_MESSAGE;
        return result + System.lineSeparator();
    }
}
