package wasteDisposal.core;

import wasteDisposal.core.contracts.CommandInterpreter;
import wasteDisposal.core.contracts.Runnable;
import wasteDisposal.io.contracts.Reader;
import wasteDisposal.io.contracts.Writer;
import wasteDisposal.utilities.Messages;

import java.io.IOException;
import java.util.Arrays;

public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private CommandInterpreter commandInterpreter;
    private boolean isRunning;

    public Engine(Reader reader, Writer writer, CommandInterpreter commandInterpreter) {
        this.reader = reader;
        this.writer = writer;
        this.commandInterpreter = commandInterpreter;
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
        String command = Arrays.stream(line.split("\\s+")).findFirst().orElse(null);
        if (command.equals(Messages.PROGRAM_END_COMMAND)) {
            this.isRunning = false;
            return;
        }
        String[] args = Arrays.stream(line.split("[ \\|]+".trim())).skip(1).toArray(String[]::new);

        String resultOfCommand = this.commandInterpreter.interpretCommand(command, args);

        this.writer.writeLine(resultOfCommand);
    }
}
