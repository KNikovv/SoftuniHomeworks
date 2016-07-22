package infernoinfinity.commands;

import infernoinfinity.interfaces.Command;
import infernoinfinity.interfaces.WeaponRepository;

public abstract class AbstractCommand implements Command {

    private WeaponRepository weaponRepository;

    protected AbstractCommand(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    protected WeaponRepository getWeaponRepository() {
        return this.weaponRepository;
    }
}
