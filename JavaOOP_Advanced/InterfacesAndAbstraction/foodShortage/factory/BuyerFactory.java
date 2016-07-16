package foodShortage.factory;

import foodShortage.interfaces.Buyer;
import foodShortage.models.Citizen;
import foodShortage.models.Rebel;

public class BuyerFactory {

    public Buyer createBuyer(String... args) {

        switch (args.length) {
            case 3:
                return new Rebel(args[0], Integer.valueOf(args[1]), args[2]);
            case 4:
                return new Citizen(args[0], Integer.valueOf(args[1]), args[2], args[3]);
        }
        return null;
    }
}
