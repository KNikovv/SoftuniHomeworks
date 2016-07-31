package pr1984.core.interfaces;

import pr1984.models.interfaces.Entity;
import pr1984.models.interfaces.Observer;

public interface Repository {

    void addObserver(Observer observer);

    void addEntity(Entity entity);

    String getAllChangeLogs();

    Entity getEntityById(String id);

    void subscribeEntities(Observer observer);
}
