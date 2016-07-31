package pr1984.factories;

import pr1984.factories.interfaces.ObserverFactory;
import pr1984.models.Institution;
import pr1984.models.interfaces.Observer;

public class ObserverFactoryImpl implements ObserverFactory {

    @Override
    public Observer createObserver(String id, String name) {
        return new Institution(id, name);
    }
}
