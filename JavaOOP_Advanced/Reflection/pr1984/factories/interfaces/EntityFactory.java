package pr1984.factories.interfaces;

import pr1984.models.interfaces.Entity;

public interface EntityFactory {

    Entity createEntity(String[] args) throws ReflectiveOperationException;
}
