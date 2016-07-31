package pr1984.models;

import pr1984.models.interfaces.ChangeEvent;
import pr1984.models.interfaces.Entity;

import java.lang.reflect.Field;

public class ChangeEventImpl<T> implements ChangeEvent<T> {

    private Entity source;
    private Field field;
    private T oldValue;
    private T newValue;

    public ChangeEventImpl(Entity source,Field field, T oldValue, T newValue) {
        this.source = source;
        this.field = field;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public Entity getEventSource() {
        return this.source;
    }

    @Override
    public Field fieldChanged() {
        return this.field;
    }

    @Override
    public T getOldValue() {
        return this.oldValue;
    }

    @Override
    public T getNewValue() {
        return this.newValue;
    }
}
