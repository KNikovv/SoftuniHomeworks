package eventimplementation.models;

import eventimplementation.interfaces.NameChangeListener;

public class HandlerImpl implements NameChangeListener {

    @Override
    public void handleChangeName(NameChangeEvent event) {
        System.out.printf("Dispatcher's name changed to %s.\n",event.getName());
    }
}
