package petclinics;

import petclinics.interfaces.CommandDispatcher;
import petclinics.interfaces.Engine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CommandDispatcher commandDispatcher = new ClinicCommandDispatcherImpl();
        Engine engine = new EngineImpl(commandDispatcher);
        engine.run();
    }
}
