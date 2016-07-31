package mirrorimage.core;

import mirrorimage.core.interfaces.Executable;
import mirrorimage.core.interfaces.Runnable;
import mirrorimage.core.interfaces.WizardData;
import mirrorimage.factories.WizardFactory;
import mirrorimage.io.interfaces.Reader;
import mirrorimage.io.interfaces.Writer;
import mirrorimage.models.interfaces.Wizard;

import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;
    private Executable executable;
    private Writer writer;

    public Engine(Reader reader, Writer writer, Executable executable) {
        this.reader = reader;
        this.writer = writer;
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
        this.printResults();
    }

    private void printResults() {
        String allSpellsCasted = WizardDataImpl.getInstance().getSpellResults();
        this.writer.writeLine(allSpellsCasted);
    }

    private void createFirstWizard(String... data) {
        String name = data[0];
        int initialDamage = Integer.valueOf(data[1]);
        Wizard wizard = WizardFactory.createWizard(name, initialDamage);

        WizardData wizardData = WizardDataImpl.getInstance();
        wizardData.addWizard(wizard);
    }
}
