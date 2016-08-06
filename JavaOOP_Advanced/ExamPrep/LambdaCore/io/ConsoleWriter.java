package bg.softuni.models.io;

import bg.softuni.models.io.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String output) {
        System.out.print(output);
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
