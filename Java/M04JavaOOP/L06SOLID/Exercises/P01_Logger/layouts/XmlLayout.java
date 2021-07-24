package P01_Logger.layouts;

import P01_Logger.enumerations.ReportLevel;
import P01_Logger.layouts.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format( "<log>\r\n" +
                "   <date>%s</date>\n" +
                "   <level>%s</level>\r\n" +
                "   <message>%s</message>\n" +
                "</log>\r\n",date,reportLevel.toString(),message);
    }
}
