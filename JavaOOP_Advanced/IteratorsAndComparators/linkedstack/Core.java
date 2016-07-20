package lineardatastructures.linkedstack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Core {

    private SimpleCommandDispatcher commandDispatcher;
    private BufferedReader bufferedReader;

    public Core(SimpleCommandDispatcher commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        while (true) {
            String[] params = this.bufferedReader.readLine().split("[ ,]+");
            String command = params[0];
            List<Integer> toPush = Arrays.stream(params).skip(1).map(Integer::parseInt).collect(Collectors.toList());
            this.commandDispatcher.dispatch(command, toPush);
            if (command.equals("END")) {
                break;
            }
        }
    }

}
