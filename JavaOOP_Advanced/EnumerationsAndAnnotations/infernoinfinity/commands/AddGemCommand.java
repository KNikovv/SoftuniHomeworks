package infernoinfinity.commands;

import infernoinfinity.enums.Gem;
import infernoinfinity.interfaces.WeaponRepository;

public class AddGemCommand extends AbstractCommand {

    public AddGemCommand(WeaponRepository weaponRepository) {
        super(weaponRepository);
    }

    @Override
    public String execute(String... params) {
        String weaponName = params[1];
        int socketIndex = Integer.valueOf(params[2]);
        Gem gemType = Gem.valueOf(params[3]);

        this.getWeaponRepository().addGemToSocket(weaponName, socketIndex, gemType);

        return null;
    }
}
