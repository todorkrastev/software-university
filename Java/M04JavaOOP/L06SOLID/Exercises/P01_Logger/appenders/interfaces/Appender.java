package P01_Logger.appenders.interfaces;

import P01_Logger.enumerations.ReportLevel;

import java.io.IOException;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message) throws IOException;
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
}
