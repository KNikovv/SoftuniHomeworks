package infernoinfinity.interfaces;

import java.io.IOException;

public interface Engine {

    void run() throws IOException;

    String[] splitInput(String input) throws IOException;
}
