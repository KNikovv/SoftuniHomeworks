package infernoinfinity.commands;

import infernoinfinity.interfaces.WeaponRepository;

public class PrintAnnotationCommand extends AbstractCommand {

    public PrintAnnotationCommand(WeaponRepository weaponRepository) {
        super(weaponRepository);
    }

    @Override
    public String execute(String... params) {
        String annotationType = params[0];

        return this.getWeaponRepository().getAnnotationAsString(annotationType);
    }
}
