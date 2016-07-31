package eventimplementation.interfaces;

import eventimplementation.models.NameChangeEvent;

public interface NameChangeListener {

    void handleChangeName(NameChangeEvent event);
}
