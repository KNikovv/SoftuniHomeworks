package listyiterator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CommandDispatcherImpl commandDispatcher = new CommandDispatcherImpl();
        Core core = new Core(commandDispatcher);

        core.run();
    }
}
