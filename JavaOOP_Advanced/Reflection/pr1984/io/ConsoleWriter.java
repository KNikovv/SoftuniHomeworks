package pr1984.io;

import pr1984.io.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void write(String output) {
        System.out.print(output);
    }
}
