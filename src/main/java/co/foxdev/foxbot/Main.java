package co.foxdev.foxbot;

import org.slf4j.Logger;
import org.slf4j.impl.SimpleLogger;
import org.slf4j.impl.SimpleLoggerFactory;

public class Main extends FoxBot
{
    // Get the build version from the manifest.
    protected static final String VERSION = Main.class.getPackage().getImplementationVersion();
    protected static Logger logger;

    public static void main(String[] args)
    {
        // Parse args
        if (args.length == 1)
        {
            switch (args[0])
            {
                // Print help dialogue and exit.
                case "-h":
                case "--help":
                    printHelp();
                // Show version dialogue and exit.
                case "-v":
                case "--version":
                    System.out.println("You are running FoxBot " + getVersion());
                    System.exit(0);
                // Set debug in config?
                case "-d":
                case "--debug":
                    System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
                    break;
                // Sets debug to trace.
                case "-t":
                case "--trace":
                    System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "trace");
                    break;
                default:
                    break;
            }
        }
        // Set logger properties.
        System.setProperty(SimpleLogger.SHOW_DATE_TIME_KEY, "true");
        System.setProperty(SimpleLogger.DATE_TIME_FORMAT_KEY, "[HH:mm:ss]");
        System.setProperty(SimpleLogger.SHOW_THREAD_NAME_KEY, "false");
        System.setProperty(SimpleLogger.LEVEL_IN_BRACKETS_KEY, "true");
        System.setProperty(SimpleLogger.SHOW_LOG_NAME_KEY, "false");

        // Initialise logger.
        logger = new SimpleLoggerFactory().getLogger(Main.class.getName());

        getLogger().info("Starting Main " + getVersion());
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
}
