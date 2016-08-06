package bg.softuni.models.io;

import bg.softuni.models.io.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {

    private BufferedReader bufferedReader;

    public ConsoleReader() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return this.bufferedReader.readLine();
    }
}
