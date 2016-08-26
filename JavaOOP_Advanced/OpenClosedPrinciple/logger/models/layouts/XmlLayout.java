package logger.models.layouts;

import logger.enums.ReportLevel;

public class XmlLayout implements Layout {

    public XmlLayout() {
    }

    @Override
    public String stringFormat(String dateTime, String message, ReportLevel reportLevel) {
        return "<log>\n" +
                "\t<date>" + dateTime + "</date>\n" +
                "\t<level>" + reportLevel + "</level>\n" +
                "\t<message>" + message+  "</message>\n" +
                "</log>";
    }
}
