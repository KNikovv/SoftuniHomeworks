package infernoinfinity.io;

import infernoinfinity.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String output) {
        System.out.printf(output);
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
