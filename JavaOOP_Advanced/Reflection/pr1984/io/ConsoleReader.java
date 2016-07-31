package pr1984.io;

import pr1984.io.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {

    private BufferedReader bufferedReader;
    private InputStreamReader inputStreamReader;

    public ConsoleReader() {
        this.inputStreamReader = new InputStreamReader(System.in);
        this.bufferedReader = new BufferedReader(this.inputStreamReader);
    }

    @Override
    public String readLine() throws IOException {
        return this.bufferedReader.readLine();
    }
}
