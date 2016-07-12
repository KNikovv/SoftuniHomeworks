package militaryElite;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MilitaryBase militaryBase = new MilitaryBase();
        CommandDispatcher commandDispatcher = new CommandDispatcher(militaryBase);

        commandDispatcher.process();
    }
}
