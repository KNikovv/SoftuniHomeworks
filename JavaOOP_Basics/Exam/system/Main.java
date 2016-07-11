package exam;

import exam.commands.CommandDispatcher;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        CommandDispatcher commandDispatcher = new CommandDispatcher();
        SystemCore systemCore = new SystemCore(commandDispatcher);

        systemCore.processInput();
    }
}
