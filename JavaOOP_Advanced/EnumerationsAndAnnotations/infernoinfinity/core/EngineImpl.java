package infernoinfinity.core;

import infernoinfinity.interfaces.CommandInterpreter;
import infernoinfinity.interfaces.Engine;
import infernoinfinity.interfaces.Reader;
import infernoinfinity.interfaces.Writer;
import infernoinfinity.io.ConsoleReader;
import infernoinfinity.io.ConsoleWriter;

import java.io.IOException;

public class EngineImpl implements Engine {

    private CommandInterpreter commandInterpreter;
    private Reader reader;
    private Writer writer;

    public EngineImpl(CommandInterpreter commandInterpreter) {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.commandInterpreter = commandInterpreter;
        this.commandInterpreter.seedCommands();
    }

    @Override
    public void run() throws IOException {
        while (true) {
            String input = this.reader.readLine();
            if (input.toLowerCase().equals("end")) {
                break;
            }
            String[] params = input.split(";");
            String command = params[0];

            String output = this.commandInterpreter.dispatch(command, params);
            if (output != null) {
                this.writer.writeLine(output);
            }
        }
    }
}
