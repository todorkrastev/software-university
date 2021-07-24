package P01_Logger.layouts.interfaces;

import P01_Logger.enumerations.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}