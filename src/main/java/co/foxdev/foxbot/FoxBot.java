package co.foxdev.foxbot;

import org.slf4j.Logger;

public abstract class FoxBot
{
    // Get the build version from the manifest.
    private static final String VERSION = Main.class.getPackage().getImplementationVersion();

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
        return Main.logger;
    }
}
