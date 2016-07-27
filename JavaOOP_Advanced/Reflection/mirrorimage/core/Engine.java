package mirrorimage.core;

import mirrorimage.core.interfaces.Executable;
import mirrorimage.core.interfaces.Runnable;
import mirrorimage.core.interfaces.WizardData;
import mirrorimage.factories.WizardFactory;
import mirrorimage.io.interfaces.Reader;
import mirrorimage.models.interfaces.Wizard;

import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;
    private Executable executable;

    public Engine(Reader reader, Executable executable) {
        this.reader = reader;
        this.executable = executable;
    }

    @Override
    public void run() throws IOException {
        String[] input = this.reader.readLine().split("\\s+");
        this.createFirstWizard(input);

        while (true) {
            input = this.reader.readLine().split("\\s+");
            if (input[0].toLowerCase().equals("end")) {
                break;
            }
            this.executable.execute(input);
        }
    }

    private void createFirstWizard(String... data) {
        String name = data[0];
        int initialDamage = Integer.valueOf(data[1]);
        Wizard wizard = WizardFactory.createWizard(name, initialDamage);

        WizardData wizardData = WizardDataImpl.getInstance();
        wizardData.addWizard(wizard);
    }
}
