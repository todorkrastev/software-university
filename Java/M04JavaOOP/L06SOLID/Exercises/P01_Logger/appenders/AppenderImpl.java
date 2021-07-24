package P01_Logger.appenders;

import P01_Logger.appenders.interfaces.Appender;
import P01_Logger.enumerations.ReportLevel;
import P01_Logger.layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {

    private final Layout layout;
    private ReportLevel reportLevel;
    private int loggedMessages;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.setReportLevel(ReportLevel.INFO);
        this.loggedMessages = 0;

    }

    protected AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.setReportLevel(reportLevel);
        this.loggedMessages = 0;

    }

    protected String format(String data, ReportLevel reportLevel, String message) {
        this.loggedMessages++;
        return this.layout.format(data, reportLevel, message);
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {

        this.reportLevel = reportLevel;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
                , this.getClass().getSimpleName()
                , this.layout.getClass().getSimpleName()
                , this.reportLevel.toString()
                , this.loggedMessages);
    }
}
