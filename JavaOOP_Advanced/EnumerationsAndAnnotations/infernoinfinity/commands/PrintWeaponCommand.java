package infernoinfinity.commands;

import infernoinfinity.interfaces.WeaponRepository;

public class PrintWeaponCommand extends AbstractCommand {

    public PrintWeaponCommand(WeaponRepository weaponRepository) {
        super(weaponRepository);
    }

    @Override
    public String execute(String... params) {
        String weaponName = params[1];

        return this.getWeaponRepository().getWeaponToPrint(weaponName);
    }
}
