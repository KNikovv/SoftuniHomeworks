package infernoinfinity.core;

import infernoinfinity.commands.*;
import infernoinfinity.interfaces.Command;
import infernoinfinity.interfaces.CommandInterpreter;
import infernoinfinity.interfaces.WeaponRepository;

import java.util.HashMap;
import java.util.Map;

public class CommandInterpreterImpl implements CommandInterpreter {

    private Map<String, Command> commands;
    private WeaponRepository weaponRepository;

    public CommandInterpreterImpl() {
        this.weaponRepository = new WeaponRepositoryImpl();
        this.commands = new HashMap<>();
    }

    @Override
    public void seedCommands() {
        this.commands.put("Create", new CreateWeaponCommand(this.weaponRepository));
        this.commands.put("Add", new AddGemCommand(this.weaponRepository));
        this.commands.put("Remove", new RemoveGemCommand(this.weaponRepository));
        this.commands.put("Print", new PrintWeaponCommand(this.weaponRepository));
        this.commands.put("Compare", new CompareCommand(this.weaponRepository));
        this.commands.put("Author", new PrintAnnotationCommand(this.weaponRepository));
        this.commands.put("Revision", new PrintAnnotationCommand(this.weaponRepository));
        this.commands.put("Description", new PrintAnnotationCommand(this.weaponRepository));
        this.commands.put("Reviewers", new PrintAnnotationCommand(this.weaponRepository));
    }

    @Override
    public String dispatch(String command, String[] params) {
        return this.commands.get(command).execute(params);
    }

}
