package infernoinfinity.io;

import infernoinfinity.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {

    private BufferedReader bufferedReader;

    public ConsoleReader() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        this.bufferedReader = new BufferedReader(inputStreamReader);
    }

    @Override
    public String readLine() throws IOException {
        return this.bufferedReader.readLine();
    }
}
