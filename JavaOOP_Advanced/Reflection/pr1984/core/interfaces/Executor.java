package pr1984.core.interfaces;

public interface Executor {

    void executeChange(String... args) throws ReflectiveOperationException;

    void executeAddEntities(String... args) throws ReflectiveOperationException;

    void executeAddObservers(String... args);

}
