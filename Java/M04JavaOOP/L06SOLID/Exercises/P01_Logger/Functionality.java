package P01_Logger;

import P01_Logger.appenders.SocketAppender;
import P01_Logger.appenders.interfaces.Appender;
import P01_Logger.layouts.XmlLayout;
import P01_Logger.layouts.interfaces.Layout;
import P01_Logger.loggers.MessageLogger;
import P01_Logger.loggers.interfaces.Logger;

import java.io.IOException;

public abstract class Functionality {

    public static void connectToServer(String dade,String message) throws IOException {
        Layout layout = new XmlLayout();
        Appender appender = new SocketAppender(layout);
        Logger logger = new MessageLogger(appender);
        logger.logInfo("16.03.20021","Hello Gogo");
    }
}
