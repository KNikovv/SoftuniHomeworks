package borderControl.models;

import borderControl.interfaces.Birthdateable;

public class Pet implements Birthdateable {

    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }
}
