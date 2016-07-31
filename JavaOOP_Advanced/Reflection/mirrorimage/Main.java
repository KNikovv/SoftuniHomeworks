package mirrorimage;

import mirrorimage.core.Command;
import mirrorimage.core.Engine;
import mirrorimage.core.interfaces.Executable;
import mirrorimage.core.interfaces.Runnable;
import mirrorimage.io.ConsoleReader;
import mirrorimage.io.ConsoleWriter;
import mirrorimage.io.interfaces.Reader;
import mirrorimage.io.interfaces.Writer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Executable executable = new Command();

        Runnable runnable = new Engine(reader, writer,executable);
        try {
            runnable.run();
        } catch (IOException ex) {
            System.out.println((ex.getMessage()));
        }
    }
}
