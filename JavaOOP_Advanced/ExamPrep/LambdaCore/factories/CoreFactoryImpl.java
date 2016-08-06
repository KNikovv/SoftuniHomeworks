package bg.softuni.models.factories;

import bg.softuni.models.factories.interfaces.CoreFactory;
import bg.softuni.models.models.interfaces.Core;

public class CoreFactoryImpl implements CoreFactory {

    private static final String CORE_PACKAGE = "bg.softuni.models.models.cores.";
    private static final String CORE_SUFFIX = "Core";

    @Override
    @SuppressWarnings("unchecked")
    public Core createCore(String type, int durability) throws ReflectiveOperationException {
        Core core;
        Class<Core> coreClass = (Class<Core>) Class.forName(CORE_PACKAGE + type + CORE_SUFFIX);
        core = coreClass
                .getDeclaredConstructor(int.class)
                .newInstance(durability);
        return core;
    }
}
