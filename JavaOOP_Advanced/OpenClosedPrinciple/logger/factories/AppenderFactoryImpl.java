package logger.factories;

import logger.enums.ReportLevel;
import logger.models.appenders.Appender;
import logger.models.appenders.FileAppender;
import logger.models.files.File;
import logger.models.files.LogFile;
import logger.models.layouts.Layout;

public class AppenderFactoryImpl implements AppenderFactory {

    private static final String APPENDERS_PATH = "logger.models.appenders.";
    private static final String LAYOUTS_PATH = "logger.models.layouts.";

    @Override
    @SuppressWarnings("unchecked")
    public Appender createAppender(String[] params) throws ReflectiveOperationException {
        String appenderName = params[0];
        String layoutName = params[1];
        Class<Appender> appenderClass = (Class<Appender>) Class.forName(APPENDERS_PATH + appenderName);
        Class<Layout> layoutClass = (Class<Layout>) Class.forName(LAYOUTS_PATH + layoutName);
        Layout layout = layoutClass.getDeclaredConstructor().newInstance();
        Appender appender = appenderClass.getDeclaredConstructor(Layout.class).newInstance(layout);
        if (appender instanceof FileAppender) {
            File file = new LogFile();
            ((FileAppender) appender).setFile(file);
        }
        if (params.length > 2) {
            ReportLevel reportLevel = ReportLevel.valueOf(params[2]);
            appender.setReportLevel(reportLevel);
        }
        return appender;
    }
}
