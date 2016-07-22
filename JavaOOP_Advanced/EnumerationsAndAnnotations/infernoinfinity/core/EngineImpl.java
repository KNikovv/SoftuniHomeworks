package infernoinfinity.core;

import infernoinfinity.interfaces.CommandInterpreter;
import infernoinfinity.interfaces.Engine;
import infernoinfinity.interfaces.Reader;
import infernoinfinity.io.ConsoleReader;

import java.io.IOException;

public class EngineImpl implements Engine {

    private CommandInterpreter commandInterpreter;
    private Reader reader;

    public EngineImpl(CommandInterpreter commandInterpreter) {
        this.reader = new ConsoleReader();
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

            this.commandInterpreter.dispatch(command, params);
        }
    }

}
