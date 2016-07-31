package pr1984.models.interfaces;

import java.lang.reflect.Field;

public interface ChangeEvent<T> {

    Entity getEventSource();

    Field fieldChanged();

    T getOldValue();

    T getNewValue();

}
