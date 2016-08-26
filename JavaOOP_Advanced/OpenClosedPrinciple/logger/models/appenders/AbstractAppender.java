package logger.models.appenders;

import logger.enums.ReportLevel;
import logger.models.layouts.Layout;

public abstract class AbstractAppender implements Appender {

    private static final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private ReportLevel reportLevel;
    private Layout layout;
    private int messagesAppended;

    protected AbstractAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = DEFAULT_REPORT_LEVEL;
        this.setMessagesAppended(0);
    }

    public int getMessagesAppended() {
        return this.messagesAppended;
    }

    protected void setMessagesAppended(int messagesAppended) {
        this.messagesAppended = messagesAppended;
    }

    @Override
    public Layout getLayout() {
        return this.layout;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected ReportLevel getMessageReportLevel() {
        StackTraceElement method = Thread.currentThread().getStackTrace()[4];
        String reportValueString = method.getMethodName().toUpperCase().substring(3);
        ReportLevel reportLevelToReturn = ReportLevel.valueOf(reportValueString);
        return reportLevelToReturn;
    }

    protected boolean reportLevelIsAboveOrEqual(ReportLevel reportLevel) {
        return reportLevel.ordinal() >= this.reportLevel.ordinal();

    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.getLayout().getClass().getSimpleName(),
                this.reportLevel,
                this.getMessagesAppended());

    }
}
