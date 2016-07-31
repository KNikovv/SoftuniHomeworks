package pr1984.factories.interfaces;

import pr1984.models.interfaces.Observer;

public interface ObserverFactory {

    Observer createObserver(String id , String name);
}
