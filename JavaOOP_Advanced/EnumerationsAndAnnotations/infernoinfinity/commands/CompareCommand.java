package infernoinfinity.commands;

import infernoinfinity.interfaces.WeaponRepository;

public class CompareCommand extends AbstractCommand {

    public CompareCommand(WeaponRepository weaponRepository) {
        super(weaponRepository);
    }

    @Override
    public String execute(String... params) {
        String firstWeaponName = params[1];
        String secondWeaponName = params[2];

        return this.getWeaponRepository().compareWeapons(firstWeaponName, secondWeaponName);

    }
}
