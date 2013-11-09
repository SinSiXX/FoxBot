package co.foxdev.foxbot;

import org.slf4j.Logger;
import org.slf4j.impl.SimpleLogger;
import org.slf4j.impl.SimpleLoggerFactory;

public class FoxBot
{
    private static Logger logger;

    public static void main(String[] args)
    {
        // Show help dialogue and exit
        if (args.length == 1 && (args[0].equals("-h") || args[0].equals("--help") ))
            printHelp();

        // Get out of static. Static is ugly. Also, actually start this thing.
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
        // Set debug in config?
        if (args.length == 1 && (args[0].equals("-d") || args[0].equals("--debug")))
            System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");

        // Initialise logger
        logger = new SimpleLoggerFactory().getLogger(FoxBot.class.getName());

        getLogger().info("Test");
        getLogger().debug("ahuehuehue");
    }

    private static void printHelp()
    {
        System.out.println(
                "\tUsage" +
                "\n\t-h - Prints this help" +
                "\n\t-d - Enables debug"
        );
        System.exit(0);
    }

    public static Logger getLogger()
    {
        return logger;
    }
}
