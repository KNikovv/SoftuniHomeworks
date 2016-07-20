package lineardatastructures.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Core {

    private SimpleCommandDispatcher simpleCommandDispatcher;
    private BufferedReader bufferedReader;

    public Core(SimpleCommandDispatcher simpleCommandDispatcher) {
        this.simpleCommandDispatcher = simpleCommandDispatcher;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        int lineCount = Integer.valueOf(this.bufferedReader.readLine());

        for (int currentLine = 0; currentLine < lineCount; currentLine++) {
            String[] params = this.bufferedReader.readLine().split("\\s+");

            String command = params[0];
            Integer number = Integer.valueOf(params[1]);

            this.simpleCommandDispatcher.dispatch(command, number);
        }
        this.simpleCommandDispatcher.dispatch("Print", 0);
    }

}
