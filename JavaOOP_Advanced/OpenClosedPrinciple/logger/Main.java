package logger;

import logger.core.Engine;
import logger.core.interfaces.Runnable;
import logger.factories.AppenderFactory;
import logger.factories.AppenderFactoryImpl;
import logger.io.console.ConsoleReader;
import logger.io.console.ConsoleWriter;
import logger.io.interfaces.Reader;
import logger.io.interfaces.Writer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        AppenderFactory appenderFactory = new AppenderFactoryImpl();
        Runnable engine = new Engine(reader,writer,appenderFactory);
        try {
            engine.run();
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
