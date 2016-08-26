package logger.models.appenders;

import logger.enums.ReportLevel;
import logger.models.files.File;
import logger.models.layouts.Layout;

public class FileAppender extends AbstractAppender {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateAndTime, String message) {
        ReportLevel reportLevel = super.getMessageReportLevel();
        if (super.reportLevelIsAboveOrEqual(reportLevel)) {
            String output = this.getLayout().stringFormat(dateAndTime, message, reportLevel);
            this.file.write(output);
            this.setMessagesAppended(this.getMessagesAppended() + 1);
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
