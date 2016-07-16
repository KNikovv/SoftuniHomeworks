package telephony.models;

import telephony.interfaces.IBrowser;
import telephony.interfaces.ICall;

public class Smartphone implements ICall, IBrowser {


    public Smartphone() {

    }


    @Override
    public void callNumber(String number) {
        if (number.matches("\\d*")) {
            System.out.printf("Calling... %s%n", number);
            return;
        }
        throw new IllegalArgumentException("Invalid number!");

    }

    @Override
    public void browseSite(String site) {
        if (site.matches("\\D*")) {
            System.out.printf("Browsing: %s!%n", site);
            return;
        }
        throw new IllegalArgumentException("Invalid URL!");
    }

}
