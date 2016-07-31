package eventimplementation.models;

import java.util.EventObject;

public class NameChangeEvent extends EventObject {

    private String name;

    public NameChangeEvent(Object source, String name) {
        super(source);
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}

