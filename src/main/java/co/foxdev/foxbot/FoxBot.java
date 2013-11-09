package co.foxdev.foxbot;

import org.slf4j.Logger;
import org.slf4j.impl.SimpleLogger;
import org.slf4j.impl.SimpleLoggerFactory;

public class FoxBot
{
    private static Logger logger;

    public static void main(String[] args)
    {
        // Get out of static. Static is ugly.
        new FoxBot().start(args);
    }

    private void start(String[] args)
    {
        // Set logger properties
        System.setProperty(SimpleLogger.SHOW_DATE_TIME_KEY, "true");
        System.setProperty(SimpleLogger.DATE_TIME_FORMAT_KEY, "[HH:mm:ss]");
        System.setProperty(SimpleLogger.SHOW_THREAD_NAME_KEY, "false");
        System.setProperty(SimpleLogger.LEVEL_IN_BRACKETS_KEY, "true");
        System.setProperty(SimpleLogger.SHOW_LOG_NAME_KEY, "false");

        // Initialise logger
        logger = new SimpleLoggerFactory().getLogger(FoxBot.class.getName());

        getLogger().info("Test");
    }

    public static Logger getLogger()
    {
        return logger;
    }
}
