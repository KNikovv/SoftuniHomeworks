package infernoinfinity;

import infernoinfinity.interfaces.CommandInterpreter;
import infernoinfinity.interfaces.Engine;
import infernoinfinity.core.CommandInterpreterImpl;
import infernoinfinity.core.EngineImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl();
        Engine engine = new EngineImpl(commandInterpreter);

        engine.run();
    }
}
