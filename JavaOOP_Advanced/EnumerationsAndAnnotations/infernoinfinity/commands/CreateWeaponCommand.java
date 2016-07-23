package infernoinfinity.commands;

import infernoinfinity.enums.WeaponType;
import infernoinfinity.interfaces.WeaponRepository;

public class CreateWeaponCommand extends AbstractCommand {

    public CreateWeaponCommand(WeaponRepository weaponRepository) {
        super(weaponRepository);
    }

    @Override
    public void execute(String... params) {
        WeaponType weaponType = Enum.valueOf(WeaponType.class, params[1]);
        String weaponName = params[2];

        this.getWeaponRepository().createWeapon(weaponType, weaponName);
    }
}
