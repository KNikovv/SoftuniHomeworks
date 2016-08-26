package logger.models.appenders;

import logger.enums.ReportLevel;
import logger.models.layouts.Layout;

public interface Appender {

    void append(String dateAndTime,String message);

    void setReportLevel(ReportLevel reportLevel);

    Layout getLayout();
}
