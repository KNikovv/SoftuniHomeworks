package pr0304Barracks.contracts;

import pr0304Barracks.core.CommandInterpreterImpl;

public interface Injector {

    void injectDependencies(Executable executable, Class to , CommandInterpreterImpl from)
            throws ReflectiveOperationException;
}
