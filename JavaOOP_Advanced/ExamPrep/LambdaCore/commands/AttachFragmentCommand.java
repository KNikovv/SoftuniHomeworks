package bg.softuni.models.commands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.constants.Messages;
import bg.softuni.models.factories.interfaces.FragmentFactory;
import bg.softuni.models.models.interfaces.Fragment;

public class AttachFragmentCommand extends CommandAbstract {

    @Inject
    private FragmentFactory fragmentFactory;

    public AttachFragmentCommand() {

    }

    @Override
    public String execute(String... args) throws ReflectiveOperationException {
        String result;

        String fragmentType = args[0];
        String fragmentName = args[1];
        int pressureAffection = Integer.valueOf(args[2]);

        try {
            Fragment fragment = this.fragmentFactory.createFragment(fragmentType, fragmentName, pressureAffection);
            this.getPowerPlant().attachFragmentToSelectedCore(fragment);
            result = String.format(Messages.SUCCESSFULLY_ATTTACHED_FRAGMENT_MESSAGE,
                    fragmentName,
                    this.getPowerPlant().getSelectedCoreName());
        } catch (IllegalArgumentException e) {
            result = String.format(Messages.FAILED_TO_ATTACH_FRAGMENT_MESSAGE,
                    fragmentName);
        }

        return result + System.lineSeparator();
    }
}
