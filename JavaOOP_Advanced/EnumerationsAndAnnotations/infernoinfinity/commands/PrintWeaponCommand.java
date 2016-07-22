package infernoinfinity.commands;

import infernoinfinity.interfaces.WeaponRepository;

public class PrintWeaponCommand extends AbstractCommand {

    public PrintWeaponCommand(WeaponRepository weaponRepository) {
        super(weaponRepository);
    }

    @Override
    public void execute(String... params) {
        String weaponName = params[1];
        this.getWeaponRepository().print(weaponName);
    }
}
