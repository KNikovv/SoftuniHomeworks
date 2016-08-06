package bg.softuni.models.core;

import bg.softuni.models.core.interfaces.CommandDispatcher;
import bg.softuni.models.core.interfaces.Runnable;
import bg.softuni.models.io.interfaces.Reader;
import bg.softuni.models.io.interfaces.Writer;

import java.io.IOException;
import java.util.Arrays;

public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private CommandDispatcher commandDispatcher;
    private boolean isRunning;

    public Engine(Reader reader,
                  Writer writer,
                  CommandDispatcher commandDispatcher) {
        this.reader = reader;
        this.writer = writer;
        this.commandDispatcher = commandDispatcher;
        this.isRunning = true;
    }

    @Override
    public void run() throws IOException, ReflectiveOperationException {

        while (this.isRunning) {
            String line = this.reader.readLine();

            this.process(line);
        }
    }

    private void process(String line) throws ReflectiveOperationException {

        if (line.equals("System Shutdown!")) {
            this.isRunning = false;
            return;
        }

        String command = line.substring(0, line.indexOf(":"));

        String[] args = Arrays.stream(line.split("\\@")).skip(1).toArray(String[]::new);

        String commandResult = this.commandDispatcher.dispatch(command, args);

        this.writer.write(commandResult);
    }
}
