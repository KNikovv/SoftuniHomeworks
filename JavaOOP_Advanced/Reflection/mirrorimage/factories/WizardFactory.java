package mirrorimage.factories;

import mirrorimage.models.WizardImpl;
import mirrorimage.models.interfaces.Wizard;

public class WizardFactory {

    private static int id = 0;

    public static Wizard createWizard(String name, int power) {
        int nextId = id++;
        return new WizardImpl(nextId, name, power);
    }
}
