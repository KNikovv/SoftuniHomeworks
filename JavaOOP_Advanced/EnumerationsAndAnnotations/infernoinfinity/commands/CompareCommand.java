package infernoinfinity.commands;

import infernoinfinity.interfaces.WeaponRepository;

public class CompareCommand extends AbstractCommand {

    public CompareCommand(WeaponRepository weaponRepository) {
        super(weaponRepository);
    }

    @Override
    public void execute(String... params) {
        String firstWeaponName = params[1];
        String secondWeaponName = params[2];

        this.getWeaponRepository().compareWeapons(firstWeaponName,secondWeaponName);
    }
}
