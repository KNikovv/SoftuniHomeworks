package logger.factories;

import logger.models.appenders.Appender;

public interface AppenderFactory {

    Appender createAppender(String[] params) throws ReflectiveOperationException;
}
