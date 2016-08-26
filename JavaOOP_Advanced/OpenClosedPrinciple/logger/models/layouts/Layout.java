package logger.models.layouts;

import logger.enums.ReportLevel;

public interface Layout {

    String stringFormat(String dateTime , String message, ReportLevel reportLevel);

}
