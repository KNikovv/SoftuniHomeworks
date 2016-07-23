package infernoinfinity.commands;

import infernoinfinity.interfaces.WeaponRepository;

public class RemoveGemCommand extends AbstractCommand {

    public RemoveGemCommand(WeaponRepository weaponRepository) {
        super(weaponRepository);
    }

    @Override
    public String execute(String... params) {
        String weaponName = params[1];
        int socketIndex = Integer.valueOf(params[2]);
        this.getWeaponRepository().removeGemFromSocket(weaponName, socketIndex);
        return null;
    }
}
