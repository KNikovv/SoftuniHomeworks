package logger.core.interfaces;

public interface Controller {

    void log(String [] args) throws ReflectiveOperationException;

    String getLogs();
}
