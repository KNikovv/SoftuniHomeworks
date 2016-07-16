package borderControl;

import borderControl.interfaces.Birthdateable;
import borderControl.models.Citizen;
import borderControl.models.Pet;

public class Factory {

    public Birthdateable createUnit(String... args) {
        switch (args.length) {
            case 3:
                if (args[0].equals("Pet")) {
                    return new Pet(args[1], args[2]);
                }
                break;
            case 5:
                return new Citizen(args[1], Integer.valueOf(args[2]), args[3], args[4]);
        }
        return null;
    }
}
