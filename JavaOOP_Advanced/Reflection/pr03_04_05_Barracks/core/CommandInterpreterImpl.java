package pr0304Barracks.core;

import pr0304Barracks.contracts.*;

import java.lang.reflect.Constructor;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PACKAGE = "pr0304Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;
    private Injector dependencyInjector;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory, Injector dependencyInjector) {
        this.repository = repository;
        this.unitFactory = unitFactory;
        this.dependencyInjector = dependencyInjector;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable;
        try {
            char firstLetter = Character.toUpperCase(commandName.charAt(0));
            String className = COMMANDS_PACKAGE + firstLetter + commandName.substring(1) + "Command";
            Class<Executable> exeClass = (Class<Executable>) Class.forName(className);
            Constructor<Executable> ctorCommand = exeClass
                    .getDeclaredConstructor(String[].class);
            ctorCommand.setAccessible(true);
            executable = ctorCommand.newInstance((Object) data);
            this.dependencyInjector.injectDependencies(executable, exeClass, this);
            return executable;
        } catch (ReflectiveOperationException roe) {
            throw new RuntimeException("Invalid command!");
        }
    }
}
