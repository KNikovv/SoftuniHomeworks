package bg.softuni.models.factories.interfaces;

import bg.softuni.models.models.interfaces.Core;

public interface CoreFactory {

    Core createCore(String type, int durability) throws ReflectiveOperationException;
}
