package co.foxdev.foxbot;

import org.slf4j.Logger;
import org.slf4j.impl.SimpleLogger;
import org.slf4j.impl.SimpleLoggerFactory;

public class FoxBot
{
    // Get the build version from the manifest.
    private static final String VERSION = FoxBot.class.getPackage().getImplementationVersion();
    // SLF4J <3
    private static Logger logger;

    public static void main(String[] args)
    {
        // Show help dialogue and exit.
        if (args.length == 1 && (args[0].equals("-h") || args[0].equals("--help")))
            printHelp();
        // Show version dialogue and exit.
        if (args.length == 1 && (args[0].equals("-v") || args[0].equals("--version")))
        {
            System.out.println("You are running FoxBot " + getVersion());
            System.exit(0);
        }

        // Get out of static. Static is ugly. Also, actually start this thing.
        new FoxBot().start(args);
    }

    private void start(String[] args)
    {
        // Set logger properties.
        System.setProperty(SimpleLogger.SHOW_DATE_TIME_KEY, "true");
        System.setProperty(SimpleLogger.DATE_TIME_FORMAT_KEY, "[HH:mm:ss]");
        System.setProperty(SimpleLogger.SHOW_THREAD_NAME_KEY, "false");
        System.setProperty(SimpleLogger.LEVEL_IN_BRACKETS_KEY, "true");
        System.setProperty(SimpleLogger.SHOW_LOG_NAME_KEY, "false");
        // Set debug in config?
        if (args.length == 1 && (args[0].equals("-d") || args[0].equals("--debug")))
            System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
        // Set log level to trace.
        if (args.length == 1 && (args[0].equals("-t") || args[0].equals("--trace")))
            System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "trace");

        // Initialise logger.
        logger = new SimpleLoggerFactory().getLogger(FoxBot.class.getName());

        getLogger().info("Starting FoxBot " + getVersion());
        getLogger().debug("ahuehuehue");
    }

    // Prints a help dialogue listing all possible startup flags.
    private static void printHelp()
    {
        System.out.println(
                "Usage" +
                "\n-h Prints this help" +
                "\n-v Prints the bot version" +
                "\n-d Enables debug" +
                "\n-t Sets the log level to trace"
        );
        System.exit(0);
    }

    /**
     * Gets the version of this bot instance
     *
     * @return Current bot version
     */
    public static String getVersion()
    {
        return VERSION;
    }

    /**
     * Gets the current bots logger
     *
     * @return Current bot logger
     */
    public static Logger getLogger()
    {
        return logger;
    }
}
