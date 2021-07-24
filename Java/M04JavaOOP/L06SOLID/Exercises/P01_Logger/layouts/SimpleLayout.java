package P01_Logger.layouts;

import P01_Logger.enumerations.ReportLevel;
import P01_Logger.layouts.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s",date,reportLevel.toString(),message);
    }
}
