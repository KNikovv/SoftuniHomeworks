package infernoinfinity.commands;

import infernoinfinity.interfaces.WeaponRepository;

public class PrintAnnotationCommand extends AbstractCommand {

    public PrintAnnotationCommand(WeaponRepository weaponRepository) {
        super(weaponRepository);
    }

    @Override
    public void execute(String... params) {
        String annotationType = params[0];

        this.getWeaponRepository().printAnnotation(annotationType);
    }
}
