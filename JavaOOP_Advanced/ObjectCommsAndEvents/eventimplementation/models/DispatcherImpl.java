package eventimplementation.models;

import eventimplementation.interfaces.Dispatcher;
import eventimplementation.interfaces.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

public class DispatcherImpl implements Dispatcher {

    private String name;
    private List<NameChangeListener> listeners;

    public DispatcherImpl(String name) {
        this.listeners = new ArrayList<>();
        this.setName(name);
    }

    public String getName(){
       return this.name;
    }

    public void setName(String name) {
        this.name = name;
        this.fireNameChangeEvent();
    }

    @Override
    public void addNameChangeListener(NameChangeListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeNameChangeListener(NameChangeListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void fireNameChangeEvent() {
        NameChangeEvent event = new NameChangeEvent(this, this.getName());
        for (NameChangeListener listener : this.listeners) {
            listener.handleChangeName(event);
        }
    }
}
