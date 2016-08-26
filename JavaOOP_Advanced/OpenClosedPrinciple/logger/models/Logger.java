package logger.models;

public interface Logger {

    void logError(String dateTime, String message);

    void logInfo(String dateTime, String message);

    void logCritical(String dateTime, String message);

    void logFatal(String dateTime, String message);

    void logWarning(String dateTime, String message);
}
