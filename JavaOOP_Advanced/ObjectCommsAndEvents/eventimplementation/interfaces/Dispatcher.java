package eventimplementation.interfaces;

public interface Dispatcher {

    void addNameChangeListener(NameChangeListener listener);

    void removeNameChangeListener(NameChangeListener listener);

    void fireNameChangeEvent();

    void setName(String name);
}
