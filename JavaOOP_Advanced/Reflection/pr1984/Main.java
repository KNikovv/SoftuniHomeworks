package pr1984;

import pr1984.core.Engine;
import pr1984.core.ExecutorImpl;
import pr1984.core.RepositoryImpl;
import pr1984.core.interfaces.Executor;
import pr1984.core.interfaces.Repository;
import pr1984.core.interfaces.Runnable;
import pr1984.factories.EntityFactoryImpl;
import pr1984.factories.ObserverFactoryImpl;
import pr1984.factories.interfaces.EntityFactory;
import pr1984.factories.interfaces.ObserverFactory;
import pr1984.io.ConsoleReader;
import pr1984.io.ConsoleWriter;
import pr1984.io.interfaces.Reader;
import pr1984.io.interfaces.Writer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Writer writer = new ConsoleWriter();
        Reader reader = new ConsoleReader();

        Repository repository = new RepositoryImpl();
        ObserverFactory observerFactory = new ObserverFactoryImpl();
        EntityFactory entityFactory = new EntityFactoryImpl();

        Executor executor = new ExecutorImpl(observerFactory, entityFactory, repository);
        Runnable engine = new Engine(writer, reader, executor, repository);

        try {
            engine.run();
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
